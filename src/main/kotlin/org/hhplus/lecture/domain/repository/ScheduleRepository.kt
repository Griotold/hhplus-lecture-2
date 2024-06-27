package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.infra.persistence.entity.Schedule

interface ScheduleRepository {
    fun save(schedule: Schedule): Schedule
    fun findById(id: Long): Schedule?
}