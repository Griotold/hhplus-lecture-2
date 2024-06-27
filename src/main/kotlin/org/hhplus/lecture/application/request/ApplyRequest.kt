package org.hhplus.lecture.application.request

import org.hhplus.lecture.domain.entity.Apply

data class ApplyRequest (
    val memberId: Long,
    val lectureId: Long,
)
