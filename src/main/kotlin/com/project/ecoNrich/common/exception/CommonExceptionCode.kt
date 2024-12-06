package com.project.ecoNrich.common.exception

import org.springframework.http.HttpStatus

enum class CommonExceptionCode(
        val status: HttpStatus,
        val message: String
) {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "입력값을 확인해주세요."),
    BAD_REQUEST_SALARY_OR_COMMISSION(HttpStatus.BAD_REQUEST, "Salary 및 Commission Pct 의 값이 유효하지 않습니다."),
    EMPLOYEE_NOT_EXIST(HttpStatus.BAD_REQUEST, "해당 사원이 존재하지 않습니다."),
    DUPLICATE_DATA_ERROR(HttpStatus.CONFLICT, "중복 데이터 발생했습니다. 입력값을 확인 해주세요."),
    CONSTRAINTS_ERROR(HttpStatus.BAD_REQUEST, "데이터 처리 중 오류가 발생했습니다. 입력값을 확인한 후 다시 시도해주세요."),

}