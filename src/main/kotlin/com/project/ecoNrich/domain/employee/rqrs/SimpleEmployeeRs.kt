package com.project.ecoNrich.domain.employee.rqrs

import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class SimpleEmployeeRs(
    @Schema(description = "직원 id")
    val employeeId: Long? = null,

    @Schema(description = "첫 이름")
    val firstName: String? = null,

    @Schema(description = "이메일")
    val email: String? = null,

    @Schema(description = "폰 번호")
    val phoneNumber: String? = null,

    @Schema(description = "고용된 날짜")
    val hireDate: LocalDate? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

    @Schema(description = "직업 이름")
    val jobTitle: String? = null,

){
}
