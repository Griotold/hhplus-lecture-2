package org.hhplus.lecture.application.response

data class ApplyResponse(
    val memberId: Long,
    val lectureId: Long,
    val applyStatus: String,
)