package org.hhplus.lecture.infra.persistence.jpa

import org.hhplus.lecture.infra.persistence.entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface JpaScheduleRepository : JpaRepository<Schedule, Long> {
}