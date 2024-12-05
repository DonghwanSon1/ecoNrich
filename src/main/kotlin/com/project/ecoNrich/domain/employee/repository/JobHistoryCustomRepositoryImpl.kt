package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.department.QDepartment
import com.project.ecoNrich.domain.employee.entity.QJobHistory
import com.project.ecoNrich.domain.employee.rqrs.EmployeeHistoryRs
import com.project.ecoNrich.domain.job.QJob
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class JobHistoryCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : JobHistoryCustomRepository {

  private val jobHistory: QJobHistory = QJobHistory.jobHistory
  private val job: QJob = QJob.job
  private val department: QDepartment = QDepartment.department


  override fun searchEmployeeHistory(employeeId: Long): List<EmployeeHistoryRs> {
    return queryFactory
        .select(
            Projections.fields(
                EmployeeHistoryRs::class.java,
                jobHistory.id.startDate,
                jobHistory.endDate,
                jobHistory.jobId,
                job.jobTitle,
                jobHistory.departmentId,
                department.departmentName
            )
        )
        .from(jobHistory)
        .join(job).on(jobHistory.jobId.eq(job.jobId))
        .join(department).on(jobHistory.departmentId.eq(department.departmentId))
        .where(jobHistory.id.employeeId.eq(employeeId))
        .orderBy(jobHistory.id.startDate.desc())
        .fetch()
  }
}