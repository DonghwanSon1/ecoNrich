package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeRq(
    @Schema(description = "첫 이름")
    val firstName: String? = null,

    @Schema(description = "마지막 이름")
    val lastName: String? = null,

    @Schema(description = "이메일")
    val email: String? = null,

    @Schema(description = "폰 번호")
    val phoneNumber: String? = null,

    @Schema(description = "고용된 날짜")
    val hireDate: LocalDate? = null,

    @Schema(description = "직업 ID")
    val jobId: String? = null,

    @Schema(description = "급여")
    val salary: BigDecimal? = null,

    @Schema(description = "commissionPct Pct")
    val commissionPct: BigDecimal? = null,

    @Schema(description = "매니저 ID")
    val managerId: Long? = null,

    @Schema(description = "부서 ID")
    val departmentId: Long? = null,
){
}
