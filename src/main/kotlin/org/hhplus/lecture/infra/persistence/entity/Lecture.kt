package org.hhplus.lecture.infra.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Lecture(
    title: String,
    capacity: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    var title: String = title
        protected set


    var capacity: Int = capacity
        protected set

}