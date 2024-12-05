package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class LocationRs(
    @Schema(description = "부서 위치 id")
    val locationId: Int? = null,

    @Schema(description = "나라 Id")
    val countryId: String? = null,

    @Schema(description = "도시 이름")
    val city: String? = null,

    @Schema(description = "주/도")
    val stateProvince: String? = null,

    @Schema(description = "나라 이름")
    val countryName: String? = null,

    @Schema(description = "대륙 이름")
    val regionName: String? = null,

    )
