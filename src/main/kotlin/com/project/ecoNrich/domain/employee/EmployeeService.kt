package com.project.ecoNrich.domain.employee


import com.project.ecoNrich.common.exception.CommonException
import com.project.ecoNrich.common.exception.CommonExceptionCode
import com.project.ecoNrich.domain.employee.entity.Employee
import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import com.project.ecoNrich.domain.employee.repository.EmployeeDetailViewRepository
import com.project.ecoNrich.domain.employee.repository.EmployeeRepository
import com.project.ecoNrich.domain.employee.repository.JobHistoryRepository
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val employeeDetailViewRepository: EmployeeDetailViewRepository,
    private val jobHistoryRepository: JobHistoryRepository,
) {

  fun searchEmployee(employeeId: Long): EmployeeRs {
    val entity: EmployeeDetailView = employeeDetailViewRepository.findById(employeeId).orElseThrow{
      CommonException(CommonExceptionCode.EMPLOYEE_NOT_EXIST) }

    return EmployeeRs.of(entity)
  }

  fun searchEmployeeHistory(employeeId: Long): List<EmployeeHistoryRs> {
    val rs: List<EmployeeHistoryRs> = jobHistoryRepository.searchEmployeeHistory(employeeId)

    return rs
  }

}