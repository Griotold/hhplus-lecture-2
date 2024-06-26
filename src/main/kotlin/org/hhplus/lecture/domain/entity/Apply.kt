package org.hhplus.lecture.domain.entity

import jakarta.persistence.*
import org.hhplus.lecture.domain.constant.ApplyStatus

@Entity
class Apply(
    member: Member,
    lecture: Lecture,
    applyStatus: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne(targetEntity = Member::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    var member: Member = member
        protected set

    @ManyToOne(targetEntity = Lecture::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    var lecture: Lecture = lecture
        protected set

    // 문자열로 받아서 enum으로 변환
    @Enumerated(EnumType.STRING)
    var applyStatus: ApplyStatus = ApplyStatus.valueOf(applyStatus)
        protected set
}