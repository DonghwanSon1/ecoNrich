package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class JobRs(
    @Schema(description = "직업 id")
    val jobId: String? = null,

    @Schema(description = "직업 타이틀")
    val jobTitle: String? = null,

)
