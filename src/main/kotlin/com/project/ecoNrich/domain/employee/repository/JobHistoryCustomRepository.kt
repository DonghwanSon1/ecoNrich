package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.entity.JobHistory
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import java.time.LocalDate


interface JobHistoryCustomRepository {

  fun searchEmployeeHistory(employeeId: Long): List<EmployeeHistoryRs>
  fun searchRecentHistory(employeeId: Long): JobHistory?
}