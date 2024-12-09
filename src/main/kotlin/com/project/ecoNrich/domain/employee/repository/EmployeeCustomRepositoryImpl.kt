package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.department.QDepartment
import com.project.ecoNrich.domain.employee.entity.JobHistory
import com.project.ecoNrich.domain.employee.entity.QEmployee
import com.project.ecoNrich.domain.employee.entity.QJobHistory
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.employee.rqrs.SimpleEmployeeRs
import com.project.ecoNrich.domain.job.QJob
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EmployeeCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : EmployeeCustomRepository {

  private val employee: QEmployee = QEmployee.employee
  private val job: QJob = QJob.job
  private val department: QDepartment = QDepartment.department


  override fun searchAllEmployee(): List<SimpleEmployeeRs> {
    return queryFactory
        .select(
            Projections.fields(
                SimpleEmployeeRs::class.java,
                employee.employeeId,
                employee.firstName,
                employee.email,
                employee.phoneNumber,
                employee.hireDate,
                department.departmentName,
                job.jobTitle
            )
        )
        .from(employee)
        .join(job).on(employee.job.eq(job))
        .leftJoin(department).on(employee.department.eq(department))
        .orderBy(employee.hireDate.desc())
        .fetch()

  }
}