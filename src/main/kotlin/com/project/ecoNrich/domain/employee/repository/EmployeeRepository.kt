package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Long>, EmployeeCustomRepository {

  fun findByDepartmentDepartmentId(departmentId: Long): List<Employee>

}