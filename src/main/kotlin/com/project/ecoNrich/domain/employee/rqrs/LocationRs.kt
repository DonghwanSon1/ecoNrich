package com.project.ecoNrich.domain.employee.rqrs

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class LocationRs(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "부서 위치 id")
    val locationId: Long? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "도로명 주소")
    val streetAddress: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "우편 번호")
    val postalCode: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "도시 이름")
    val city: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "주/도")
    val stateProvince: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "나라 Id")
    val countryId: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "나라 이름")
    val countryName: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "대륙 이름")
    val regionName: String? = null,

    )
