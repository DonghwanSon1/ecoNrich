package com.project.ecoNrich.domain.publicAPI

import com.project.ecoNrich.common.response.BaseResponse
import com.project.ecoNrich.domain.publicAPI.rqrs.LhLeaseInfoRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/public-api")
@Tag(name = "Public Data", description = "공공 데이터 관련 API")
class PublicApiController(
    private val publicAPIService: PublicApiService
) {

  /**
   * 공공데이터
   * - 임대주택단지 조회 API
   */
  @GetMapping
  @Operation(summary = "공공데이터 임대주택단지 조회", description = "공공데이터의 임대주택단지를 조회합니다.")
  fun getLhLeaseInfo(@RequestParam pageSize: Int = 10,
                     @RequestParam page: Int = 1,
                     @RequestParam cnpCode: String?,
                     @RequestParam splTpCode: String? ): BaseResponse<List<LhLeaseInfoRs>> {
    return BaseResponse(data = publicAPIService.getLhLeaseInfo(pageSize, page, cnpCode, splTpCode))
  }
}