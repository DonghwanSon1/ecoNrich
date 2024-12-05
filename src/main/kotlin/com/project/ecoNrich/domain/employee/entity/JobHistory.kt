package com.project.ecoNrich.domain.employee.entity

import com.project.ecoNrich.domain.department.Department
import com.project.ecoNrich.domain.job.Job
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "job_history")
class JobHistory(
    @EmbeddedId
    val id: JobHistoryId,

    @Column(name = "end_date")
    val endDate: LocalDate,

    @Column(name = "job_id")
    val jobId: String,

    @Column(name = "department_id")
    val departmentId: Int
) {
}