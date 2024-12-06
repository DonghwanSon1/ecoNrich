package com.project.ecoNrich.domain.job

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "jobs")
class Job(
    @Id
    @Column(name = "job_id")
    val jobId: String? = null,

    @Column(name = "job_title")
    val jobTitle: String? = null,

    @Column(name = "min_salary")
    val minSalary: Long? = null,

    @Column(name = "max_salary")
    val maxSalary: Long? = null
) {
}