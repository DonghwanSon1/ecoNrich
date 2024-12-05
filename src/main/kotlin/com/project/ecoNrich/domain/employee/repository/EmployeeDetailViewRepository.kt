package com.project.ecoNrich.domain.employee.repository

import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeDetailViewRepository: JpaRepository<EmployeeDetailView, Long> {


}