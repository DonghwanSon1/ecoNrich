package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class SimpleDepartmentRs(
    @Schema(description = "부서 id")
    val departmentId: Int? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

)
