package com.project.ecoNrich.domain.employee

import com.project.ecoNrich.common.response.BaseResponse
import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

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

}