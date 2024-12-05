package com.project.ecoNrich.domain.employee.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

data class EmployeeHistoryRs(
    @Schema(description = "시작 Date")
    val startDate: LocalDate? = null,

    @Schema(description = "끝 Date")
    val endDate: LocalDate? = null,

    @Schema(description = "직업 ID")
    val jobId: String? = null,

    @Schema(description = "직업 타이틀")
    val jobTitle: String? = null,

    @Schema(description = "부서 ID")
    val departmentId: Int? = null,

    @Schema(description = "부서 이름")
    val departmentName: String? = null,

){
}
