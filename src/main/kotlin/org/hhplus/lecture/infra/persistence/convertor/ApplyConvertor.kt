package org.hhplus.lecture.infra.persistence.convertor

import org.hhplus.lecture.domain.ApplyDomain
import org.hhplus.lecture.infra.persistence.entity.Apply
import org.springframework.stereotype.Component

@Component
class ApplyConvertor {

    fun toEntity(applyDomain: ApplyDomain): Apply {
        return Apply()
    }
}