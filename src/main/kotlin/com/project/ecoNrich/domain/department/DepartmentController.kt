package com.project.ecoNrich.domain.department

import com.project.ecoNrich.common.exception.CommonException
import com.project.ecoNrich.common.exception.CommonExceptionCode
import com.project.ecoNrich.common.response.BaseResponse
import com.project.ecoNrich.domain.department.rqrs.DepartmentRs
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRq
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/department")
@Tag(name = "Department", description = "부서 관련 API")
class DepartmentController(
    private val departmentService: DepartmentService
) {

  /**
   * 부서 및 위치 정보 조회 API
   */
  @GetMapping
  @Operation(summary = "부서 및 위치 정보 조회", description = "부서 및 위치 정보를 조회합니다.")
  fun searchDepartmentAndLocation(@RequestParam departmentId: Long?): BaseResponse<List<DepartmentRs>> {
    // 부서 ID 를 받지 않았을 시 전체 부서 조회한다.
    return BaseResponse(data = departmentService.searchDepartmentAndLocation(departmentId))
  }

  /**
   * 특정 부서의 특정 비율로 급여 인상 API
   */
  @PatchMapping("/salary-increase/{departmentId}")
  @Operation(summary = "특정 부서의 특정 비율로 급여 인상", description = "특정 부서의 특정 비율로 급여를 인상하여 수정합니다.")
  fun updateEmployeeSalary(@PathVariable departmentId: Long,
                           @RequestParam increaseRate: Int): BaseResponse<Unit> {
    // 인상 비율을 %를 기준으로 하며, 0이하의 값이 들어오면 Exception 발생 시킨다.
    if (increaseRate < 0) throw CommonException(CommonExceptionCode.INVALID_SALARY_INCREASE)
    val resultMsg: String = departmentService.updateEmployeeSalary(departmentId, increaseRate)
    return BaseResponse(message = resultMsg)
  }
}