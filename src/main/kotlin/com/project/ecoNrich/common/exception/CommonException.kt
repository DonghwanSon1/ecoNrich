package com.project.ecoNrich.common.exception


class CommonException(val exceptionCode: CommonExceptionCode) : RuntimeException(exceptionCode.message) {

}