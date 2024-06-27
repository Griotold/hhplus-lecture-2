package org.hhplus.lecture.infra.persistence

import org.hhplus.lecture.domain.repository.ScheduleRepository
import org.hhplus.lecture.infra.persistence.entity.Schedule
import org.hhplus.lecture.infra.persistence.jpa.JpaScheduleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ScheduleRepositoryImpl (
    private val jpaScheduleRepository: JpaScheduleRepository
) : ScheduleRepository {

    override fun save(schedule: Schedule): Schedule {
        return jpaScheduleRepository.save(schedule)
    }

    override fun findById(id: Long): Schedule? {
        return jpaScheduleRepository.findByIdOrNull(id)
    }

}