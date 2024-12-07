package com.project.ecoNrich.domain.employee.rqrs

import com.project.ecoNrich.domain.employee.entity.EmployeeDetailView
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeRs(
    @Schema(description = "직원 id")
    val employeeId: Long? = null,

    @Schema(description = "첫 이름")
    val firstName: String? = null,

    @Schema(description = "마지막 이름")
    val lastName: String? = null,

    @Schema(description = "급여")
    val salary: BigDecimal? = null,

    @Schema(description = "commissionPct Pct")
    val commissionPct: BigDecimal? = null,

    @Schema(description = "이메일")
    val email: String? = null,

    @Schema(description = "폰 번호")
    val phoneNumber: String? = null,

    @Schema(description = "고용된 날짜")
    val hireDate: LocalDate? = null,

    @Schema(description = "부서 정보")
    val department: SimpleDepartmentRs? = null,

    @Schema(description = "직업 정보")
    val job: JobRs? = null,

    @Schema(description = "부서 위치")
    val location: LocationRs? = null,
){
    companion object {
        fun of(employeeDetailViewEntity: EmployeeDetailView): EmployeeRs {
            return EmployeeRs(
                employeeId = employeeDetailViewEntity.employeeId,
                firstName = employeeDetailViewEntity.firstName,
                lastName = employeeDetailViewEntity.lastName,
                salary = employeeDetailViewEntity.salary,
                commissionPct = employeeDetailViewEntity.commissionPct,
                email = employeeDetailViewEntity.email,
                phoneNumber = employeeDetailViewEntity.phoneNumber,
                hireDate = employeeDetailViewEntity.hireDate,
                department = SimpleDepartmentRs(employeeDetailViewEntity.departmentId, employeeDetailViewEntity.departmentName),
                job = JobRs(employeeDetailViewEntity.jobId, employeeDetailViewEntity.jobTitle),
                location = LocationRs(
                    locationId = employeeDetailViewEntity.locationId,
                    countryId = employeeDetailViewEntity.countryId,
                    city = employeeDetailViewEntity.city,
                    stateProvince = employeeDetailViewEntity.stateProvince,
                    countryName = employeeDetailViewEntity.countryName,
                    regionName = employeeDetailViewEntity.regionName
                )
            )
        }
    }
}
