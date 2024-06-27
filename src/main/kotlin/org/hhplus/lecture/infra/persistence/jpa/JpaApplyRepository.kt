package org.hhplus.lecture.infra.persistence.jpa

import org.hhplus.lecture.infra.persistence.entity.Apply
import org.springframework.data.jpa.repository.JpaRepository

interface JpaApplyRepository : JpaRepository<Apply, Long> {
}