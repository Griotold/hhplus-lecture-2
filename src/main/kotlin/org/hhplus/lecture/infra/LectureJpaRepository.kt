package org.hhplus.lecture.infra

import org.hhplus.lecture.infra.entity.LectureEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LectureJpaRepository : JpaRepository<LectureEntity, Long> {
}