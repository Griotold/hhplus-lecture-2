package org.hhplus.lecture.infra.persistence.entity

import jakarta.persistence.*
import org.hhplus.lecture.domain.constant.ApplyStatus
import java.time.LocalDateTime

@Entity
class Apply(
    member: Member,
    schedule: Schedule,
    applyStatus: ApplyStatus,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne(targetEntity = Member::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    var member: Member = member
        protected set

    @ManyToOne(targetEntity = Schedule::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    var schedule: Schedule = schedule
        protected set

    @Enumerated(EnumType.STRING)
    var applyStatus: ApplyStatus = applyStatus
        protected set

    var applyAt: LocalDateTime = LocalDateTime.now()
        protected set
}