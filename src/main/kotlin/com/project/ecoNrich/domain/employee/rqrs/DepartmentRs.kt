package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class DepartmentRs(
    @Schema(description = "부서 id")
    val departmentId: Int? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

)
