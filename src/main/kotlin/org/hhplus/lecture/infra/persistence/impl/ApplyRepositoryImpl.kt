package org.hhplus.lecture.infra.persistence.impl

import org.hhplus.lecture.domain.ApplyDomain
import org.hhplus.lecture.domain.LectureDomain
import org.hhplus.lecture.domain.MemberDomain
import org.hhplus.lecture.domain.ScheduleDomain
import org.hhplus.lecture.infra.persistence.entity.Apply
import org.hhplus.lecture.domain.repository.ApplyRepository
import org.hhplus.lecture.infra.persistence.entity.Lecture
import org.hhplus.lecture.infra.persistence.entity.Member
import org.hhplus.lecture.infra.persistence.entity.Schedule
import org.hhplus.lecture.infra.persistence.jpa.JpaApplyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ApplyRepositoryImpl(
    private val jpaApplyRepository : JpaApplyRepository
) : ApplyRepository {
    override fun save(memberDomain: MemberDomain, scheduleDomain: ScheduleDomain): ApplyDomain {
        val member = Member(name = memberDomain.name)
        Lecture(title)
        Schedule()
    }


    override fun findById(id: Long): Apply? {
        return jpaApplyRepository.findByIdOrNull(id)
    }


}