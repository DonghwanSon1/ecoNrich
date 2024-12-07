package com.project.ecoNrich.domain.department.rqrs

import com.project.ecoNrich.domain.employee.rqrs.LocationRs
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class DepartmentDto(
    @Schema(description = "부서 id")
    val departmentId: Long? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

    @Schema(description = "부서 위치 id")
    val locationId: Long? = null,

    @Schema(description = "도로명 주소")
    val streetAddress: String? = null,

    @Schema(description = "우편 번호")
    val postalCode: String? = null,

    @Schema(description = "도시 이름")
    val city: String? = null,

    @Schema(description = "주/도")
    val stateProvince: String? = null,

    @Schema(description = "나라 Id")
    val countryId: String? = null,

    @Schema(description = "나라 이름")
    val countryName: String? = null,

    @Schema(description = "대륙 이름")
    val regionName: String? = null

)
