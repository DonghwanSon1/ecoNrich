package com.project.ecoNrich.domain.publicAPI.rqrs

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

data class LhLeaseInfoRs(
    @JsonProperty("SUM_HSH_CNT")
    @Schema(description = "총세대수")
    val sumHshCnt: String? = null,

    @JsonProperty("RFE")
    @Schema(description = "월임대료")
    val rfe: String? = null,

    @JsonProperty("RNUM")
    @Schema(description = "순번")
    val rNum: String? = null,

    @JsonProperty("HSH_CNT")
    @Schema(description = "세대수")
    val hshCnt: String? = null,

    @JsonProperty("ARA_NM")
    @Schema(description = "지역명")
    val araNm: String? = null,

    @JsonProperty("LS_GMY")
    @Schema(description = "임대보증금")
    val lsGmy: String? = null,

    @JsonProperty("AIS_TP_CD_NM")
    @Schema(description = "공급유형명")
    val aisTpCdNm: String? = null,

    @JsonProperty("SBD_LGO_NM")
    @Schema(description = "단지명")
    val sbdLgoNm: String? = null,

    @JsonProperty("ALL_CNT")
    @Schema(description = "전체건수")
    val allCnt: String? = null,

    @JsonProperty("DDO_AR")
    @Schema(description = "전용면적")
    val ddoAr: String? = null,

    @JsonProperty("MVIN_XPC_YM")
    @Schema(description = "최초입주년월")
    val mvinXpcYm: String? = null

)