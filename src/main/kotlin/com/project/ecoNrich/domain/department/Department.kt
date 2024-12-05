package com.project.ecoNrich.domain.department

import com.project.ecoNrich.domain.employee.entity.Employee
import com.project.ecoNrich.domain.location.Location
import javax.persistence.*

@Entity
@Table(name = "departments")
class Department(
    @Id
    @Column(name = "department_id")
    val departmentId: Int,

    @Column(name = "department_name")
    val departmentName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    val manager: Employee? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    val location: Location? = null,

    ) {
}