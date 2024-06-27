package org.hhplus.lecture.infra.persistence

import org.hhplus.lecture.infra.persistence.entity.Member
import org.hhplus.lecture.domain.repository.MemberRepository
import org.hhplus.lecture.infra.persistence.jpa.JpaMemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val jpaMemberRepository: JpaMemberRepository
) : MemberRepository {

    override fun save(member: Member): Member {
        return jpaMemberRepository.save(member)
    }

    override fun findById(id: Long): Member? {
        return jpaMemberRepository.findByIdOrNull(id)
    }
}