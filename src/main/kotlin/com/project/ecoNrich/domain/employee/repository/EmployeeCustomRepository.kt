package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.entity.JobHistory
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.SimpleEmployeeRs
import java.time.LocalDate


interface EmployeeCustomRepository {

  fun searchAllEmployee(): List<SimpleEmployeeRs>
}