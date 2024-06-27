package org.hhplus.lecture.domain

import java.time.LocalDateTime

class ScheduleDomain(
    val id : Long,
    val lectureDomain : LectureDomain,
    val applyStartAt : LocalDateTime,
    val lectureStartAt : LocalDateTime,
    val currentApplicants : Int
) {
}