package com.project.ecoNrich.domain.publicAPI.rqrs

import io.swagger.v3.oas.annotations.media.Schema


data class ResponseDto(
    @Schema(description = "응답값을 가져올 변수")
    val dsList: List<LhLeaseInfoRs>? = null,
)
