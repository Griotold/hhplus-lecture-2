package org.hhplus.lecture.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Lecture(
    title: String,
    apply_start_at: LocalDateTime,
    lecture_start_at: LocalDateTime,
    capacity: Int,
    current_applicants: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    var title: String = title
        protected set

    var apply_start_at: LocalDateTime = apply_start_at
        protected set

    var lecture_start_at: LocalDateTime = lecture_start_at
        protected set

    var capacity: Int = capacity
        protected set

    var current_applicants: Int = current_applicants
        protected set

}