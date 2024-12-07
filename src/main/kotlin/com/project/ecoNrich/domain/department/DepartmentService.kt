package com.project.ecoNrich.domain.department


import com.project.ecoNrich.domain.department.rqrs.DepartmentDto
import com.project.ecoNrich.domain.department.rqrs.DepartmentRs
import com.project.ecoNrich.domain.employee.EmployeeService
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DepartmentService(
    private val departmentRepository: DepartmentRepository,
    private val employeeService: EmployeeService
) {

  /**
   * 부서 및 위치 조회
   */
  fun searchDepartmentAndLocation(departmentId: Long?): List<DepartmentRs> {
    // Rs 형식을 맞추기 위해 Dto 대로 데이터를 가져와 Rs 형식대로 응답한다.
    val dto: List<DepartmentDto> = departmentRepository.searchDepartment(departmentId)
    return dto.map { DepartmentRs.of(it) }
  }

  /**
   * 부서의 속한 직원들의 특정 비율로 급여 인상
   */
  @Transactional
  fun updateEmployeeSalary(departmentId: Long, increaseRate: Int): String {
    // 인상 비율을 미리 계산해놓는다.
    val rate: Double = 1.0 + (increaseRate / 100.0)
    return employeeService.updateEmployeeSalary(departmentId, rate)
  }
}