package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.entity.Employee
import com.project.ecoNrich.domain.employee.entity.JobHistory
import com.project.ecoNrich.domain.employee.entity.JobHistoryId
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import org.springframework.data.jpa.repository.JpaRepository

interface JobHistoryRepository: JpaRepository<JobHistory, JobHistoryId>, JobHistoryCustomRepository {



}