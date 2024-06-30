package org.hhplus.lecture.infra.persistence.convertor

import org.hhplus.lecture.domain.ScheduleDomain
import org.hhplus.lecture.infra.persistence.entity.Schedule
import org.springframework.stereotype.Component

@Component
class ScheduleConvertor {

    fun toEntity(scheduleDomain: ScheduleDomain): Schedule {
        return Schedule()
    }
}