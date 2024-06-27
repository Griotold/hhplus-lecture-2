package org.hhplus.lecture.infra.persistence

import org.hhplus.lecture.infra.persistence.entity.Apply
import org.hhplus.lecture.domain.repository.ApplyRepository
import org.hhplus.lecture.infra.persistence.jpa.JpaApplyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ApplyRepositoryImpl(
    private val jpaApplyRepository : JpaApplyRepository
) : ApplyRepository {

    override fun save(apply: Apply): Apply {
        return jpaApplyRepository.save(apply)
    }

    override fun findById(id: Long): Apply? {
        return jpaApplyRepository.findByIdOrNull(id)
    }


}