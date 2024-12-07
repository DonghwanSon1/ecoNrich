package com.project.ecoNrich.domain.employee.entity

import org.hibernate.annotations.Immutable
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Immutable
@Table(name = "emp_details_view")
class EmployeeDetailView(
    @Id
    @Column(name = "employee_id")
    val employeeId: Long,

    @Column(name = "job_id")
    val jobId: String,

    @Column(name = "manager_id")
    val managerId: Long? = null,

    @Column(name = "department_id")
    val departmentId: Int? = null,

    @Column(name = "location_id")
    val locationId: Long? = null,

    @Column(name = "country_id")
    val countryId: String,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "salary")
    val salary: BigDecimal,

    @Column(name = "commission_pct")
    val commissionPct: BigDecimal? = null,

    @Column(name = "email")
    val email: String,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "hire_date")
    val hireDate: LocalDate,

    @Column(name = "department_name")
    val departmentName: String,

    @Column(name = "job_title")
    val jobTitle: String,

    @Column(name = "city")
    val city: String,

    @Column(name = "state_province")
    val stateProvince: String? = null,

    @Column(name = "country_name")
    val countryName: String? = null,

    @Column(name = "region_name")
    val regionName: String? = null
) {
}