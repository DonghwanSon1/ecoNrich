package com.project.ecoNrich.domain.employee

import com.project.ecoNrich.common.exception.CommonException
import com.project.ecoNrich.common.exception.CommonExceptionCode
import com.project.ecoNrich.common.response.BaseResponse
import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRq
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee", description = "사원 관련 API")
class EmployeeController(
    private val employeeService: EmployeeService
) {

  /**
   * 특정 사원의 현재 정보 조회 API
   */
  @GetMapping("/{employeeId}")
  @Operation(summary = "특정 사원의 현재 정보 조회", description = "특정 사원의 현재 정보를 조회합니다.")
  fun searchEmployee(@PathVariable employeeId: Long): BaseResponse<EmployeeRs> {
    return BaseResponse(data = employeeService.searchEmployee(employeeId))
  }

  /**
   * 특정 사원의 이력 정보 조회 API
   */
  @GetMapping("/history/{employeeId}")
  @Operation(summary = "특정 사원의 이력 정보 조회", description = "특정 사원의 이력 정보를 조회합니다.")
  fun searchEmployeeHistory(@PathVariable employeeId: Long): BaseResponse<List<EmployeeHistoryRs>> {
    val result: List<EmployeeHistoryRs> = employeeService.searchEmployeeHistory(employeeId)
    return if (result.isNotEmpty()) BaseResponse(data = result) else BaseResponse(data = result, message = "변동된 이력이 존재하지 않습니다.")
  }

  /**
   * 특정 사원의 정보 수정 API
   */
  @PatchMapping("/{employeeId}")
  @Operation(summary = "특정 사원의 정보 수정", description = "특정 사원의 정보 수정합니다.")
  fun updateEmployee(@PathVariable employeeId: Long,
                     @RequestBody rq: EmployeeRq): BaseResponse<Unit> {
    // BigDecimal 유효성 검사하여 맞지 않은 값을 준다면, Exception 발생한다.
    rq.salary?.let { validateBigDecimal(it, 8, 2) }
    rq.commissionPct?.let { validateBigDecimal(it, 2, 2) }

    val resultMsg: String = employeeService.updateEmployee(employeeId, rq)
    return BaseResponse(message = resultMsg)
  }



  /**
   * BigDecimal 유효성 검사 함수
   */
  private fun validateBigDecimal(value: BigDecimal?, maxPrecision: Int, maxScale: Int) {
    // value가 null이 아니면 유효성 검사한다.
    value?.let {
      // DB에 선언한 salary = (8,2), commissionPct = (2,2)가 아니면 삽입이 안되기 때문에 체크해줘야 한다.
      if (it.precision() > maxPrecision || value.scale() != maxScale) {
        throw CommonException(CommonExceptionCode.BAD_REQUEST_SALARY_OR_COMMISSION)
      }
    }
  }

}