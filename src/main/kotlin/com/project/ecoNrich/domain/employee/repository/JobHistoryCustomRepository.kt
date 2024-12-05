package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs


interface JobHistoryCustomRepository {

  fun searchEmployeeHistory(employeeId: Long): List<EmployeeHistoryRs>
}