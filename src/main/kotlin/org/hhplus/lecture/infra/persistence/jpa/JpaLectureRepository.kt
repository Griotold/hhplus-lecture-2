package org.hhplus.lecture.infra.persistence.jpa

import org.hhplus.lecture.infra.persistence.entity.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface JpaLectureRepository : JpaRepository<Lecture, Long> {
}