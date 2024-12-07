package com.project.ecoNrich.domain.department

import com.project.ecoNrich.domain.department.rqrs.DepartmentDto


interface DepartmentCustomRepository {

  fun searchDepartment(departmentId: Long?): List<DepartmentDto>

}