package org.hhplus.lecture.infra

import org.hhplus.lecture.infra.entity.LectureSessionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LectureSessionJpaRepository : JpaRepository<LectureSessionEntity, Long> {
}