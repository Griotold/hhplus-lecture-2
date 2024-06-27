package org.hhplus.lecture.infra.persistence.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Schedule (
    lecture: Lecture,
    applyStartAt: LocalDateTime,
    lectureStartAt: LocalDateTime,
    currentApplicants: Int
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne(targetEntity = Lecture::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    var lecture: Lecture = lecture
        protected set

    var applyStartAt: LocalDateTime = applyStartAt
        protected set

    var lectureStartAt: LocalDateTime = lectureStartAt
        protected set

    var currentApplicants: Int = currentApplicants
        protected set
}