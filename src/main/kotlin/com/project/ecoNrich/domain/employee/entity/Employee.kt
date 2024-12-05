package com.project.ecoNrich.domain.employee.entity

import com.project.ecoNrich.domain.department.Department
import com.project.ecoNrich.domain.job.Job
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employees")
class Employee(
    @Id
    @Column(name = "employee_id")
    val employeeId: Long,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "hire_date")
    val hireDate: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    val job: Job,

    @Column(name = "salary")
    val salary: BigDecimal,

    @Column(name = "commission_pct")
    val commissionPct: BigDecimal? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    val manager: Employee? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    val department: Department? = null
) {
}