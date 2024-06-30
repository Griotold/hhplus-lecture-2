package org.hhplus.lecture.exception

open class LectureEnrollmentException(message: String) : Exception(message) {
    val notNullMessage: String
        // 커스텀 게터 정의
        // message 는 null 일 수 없다고 선언
        get() = message!!
}