package com.project.ecoNrich.domain.department

import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository: JpaRepository<Department, Long>, DepartmentCustomRepository {
}