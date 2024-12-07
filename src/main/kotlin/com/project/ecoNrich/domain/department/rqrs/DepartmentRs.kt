package com.project.ecoNrich.domain.department.rqrs

import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import com.project.ecoNrich.domain.employee.rqrs.EmployeeRs
import com.project.ecoNrich.domain.employee.rqrs.JobRs
import com.project.ecoNrich.domain.employee.rqrs.LocationRs
import com.project.ecoNrich.domain.employee.rqrs.SimpleDepartmentRs
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class DepartmentRs(
    @Schema(description = "부서 id")
    val departmentId: Long? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

    @Schema(description = "위치 정보")
    val location: LocationRs? = null,

) {
    companion object {
        fun of(dto: DepartmentDto): DepartmentRs {
            return DepartmentRs(
                departmentId = dto.departmentId,
                departmentName = dto.departmentName,
                location = LocationRs(
                    locationId = dto.locationId,
                    streetAddress = dto.streetAddress,
                    postalCode = dto.postalCode,
                    city = dto.city,
                    stateProvince = dto.stateProvince,
                    countryId = dto.countryId,
                    countryName = dto.countryName,
                    regionName = dto.regionName
                )
            )
        }
    }
}
