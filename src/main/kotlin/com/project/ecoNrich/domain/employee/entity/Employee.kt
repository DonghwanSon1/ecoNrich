package com.project.ecoNrich.domain.employee.entity

import com.project.ecoNrich.domain.department.Department
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRq
import com.project.ecoNrich.domain.job.Job
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employees")
class Employee(
    @Id
    @Column(name = "employee_id")
    val employeeId: Long? = null,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String? = null,

    @Column(name = "email")
    val email: String? = null,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "hire_date")
    val hireDate: LocalDate? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    val job: Job? = null,

    @Column(name = "salary")
    var salary: BigDecimal? = null,

    @Column(name = "commission_pct")
    val commissionPct: BigDecimal? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    val manager: Employee? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    val department: Department? = null
) {
    fun update(rq: EmployeeRq): Employee {
        return Employee(
            employeeId = this.employeeId,
            firstName = rq.firstName ?: this.firstName,
            lastName = rq.lastName ?: this.lastName,
            email = rq.email ?: this.email,
            phoneNumber = rq.phoneNumber ?: this.phoneNumber,
            hireDate = rq.hireDate ?: this.hireDate,
            job = if (rq.jobId != null ) { Job(jobId = rq.jobId) } else this.job,
            salary = rq.salary ?: this.salary,
            commissionPct = rq.commissionPct ?: this.commissionPct,
            manager = if (rq.managerId != null) { Employee(employeeId = rq.managerId) } else this.manager,
            department = if (rq.departmentId != null) { Department(departmentId = rq.departmentId) } else this.department
        )
    }
}