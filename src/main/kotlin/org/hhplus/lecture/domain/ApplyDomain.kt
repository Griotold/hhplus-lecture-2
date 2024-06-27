package org.hhplus.lecture.domain

import org.hhplus.lecture.domain.constant.ApplyStatus
import java.time.LocalDateTime

data class ApplyDomain(
    val id: Long,
    val memberDomain: MemberDomain,
    val scheduleDomain: ScheduleDomain,
    val applyStatus: ApplyStatus,
    val applyAt: LocalDateTime,
) {
}