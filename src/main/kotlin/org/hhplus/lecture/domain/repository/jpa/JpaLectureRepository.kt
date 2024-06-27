package org.hhplus.lecture.domain.repository.jpa

import org.hhplus.lecture.domain.entity.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface JpaLectureRepository : JpaRepository<Lecture, Long> {
}