package org.hhplus.lecture.domain.repository.jpa

import org.hhplus.lecture.domain.entity.Apply
import org.springframework.data.jpa.repository.JpaRepository

interface JpaApplyRepository : JpaRepository<Apply, Long> {
}