package org.hhplus.lecture.domain

import org.hhplus.lecture.domain.constant.ApplyStatus
import java.time.LocalDateTime

data class ApplyDomain(
    val id: Long,
    val memberId: Long,
    val scheduleId: Long,
    val applyStatus: ApplyStatus,
    val applyAt: LocalDateTime,
)