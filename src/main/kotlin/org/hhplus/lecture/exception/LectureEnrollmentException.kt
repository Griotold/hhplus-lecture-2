package org.hhplus.lecture.exception

// 코틀린에서는 체크드와 언체크드 예외의 구분이 없다.
open class LectureEnrollmentException(message: String) : Exception(message) {
    val notNullMessage: String
        // 커스텀 게터 정의
        // message 는 null 일 수 없다고 선언
        get() = message!!
}