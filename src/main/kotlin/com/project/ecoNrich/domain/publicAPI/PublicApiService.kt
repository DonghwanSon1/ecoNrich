package com.project.ecoNrich.domain.publicAPI


import com.project.ecoNrich.common.exception.CommonException
import com.project.ecoNrich.common.exception.CommonExceptionCode
import com.project.ecoNrich.domain.publicAPI.rqrs.LhLeaseInfoRs
import com.project.ecoNrich.domain.publicAPI.rqrs.ResponseDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class PublicApiService(
    private val restTemplate: RestTemplate
) {
  @Value("\${public.api.service-key}")
  lateinit var serviceKey: String

  fun getLhLeaseInfo(pageSize: Int, page: Int, cnpCode: String?, splTpCode: String?): List<LhLeaseInfoRs>? {
    val url = UriComponentsBuilder.fromHttpUrl("https://apis.data.go.kr/B552555/lhLeaseInfo1/lhLeaseInfo1")
        .queryParam("serviceKey", serviceKey) // Service Key
        .queryParam("PG_SZ", pageSize) // 한 페이지 결과 수
        .queryParam("PAGE", page) // 페이지 수
        .queryParam("CNP_CD", cnpCode) // 지역 코드
        .queryParam("SPL_TP_CD", splTpCode) // 공급 유형 코드
        .build(true)
        .toUri()

    val headers = HttpHeaders().apply {
      set("Accept", "application/json")
    }

    return try {
      // RestTemplate을 사용하여 GET 요청한다.
      val response = restTemplate.exchange(
          url,
          HttpMethod.GET,
          HttpEntity<String>(headers),
          object : ParameterizedTypeReference<List<ResponseDto>>() {}
      ).body

      // 가져온 API를 원하는 필요한 데이터만 가져와 응답한다.
      return response!!.filter { !it.dsList.isNullOrEmpty() }.flatMap { it.dsList!! }

    } catch (e: Exception) {
      // 연동 시 Exception 발생하면 Custom Exception 으로 예외처리 한다.
      throw CommonException(CommonExceptionCode.PUBLIC_API_ERROR)
    }
  }
}