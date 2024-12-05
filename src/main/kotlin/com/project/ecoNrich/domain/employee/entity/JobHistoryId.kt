package com.project.ecoNrich.domain.employee.entity

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class JobHistoryId(
    @Column(name = "employee_id")
    val employeeId: Long,

    @Column(name = "start_date")
    val startDate: LocalDate
): Serializable
