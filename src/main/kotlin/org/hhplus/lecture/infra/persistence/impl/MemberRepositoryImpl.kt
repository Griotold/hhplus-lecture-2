package org.hhplus.lecture.infra.persistence.impl

import org.hhplus.lecture.domain.MemberDomain
import org.hhplus.lecture.domain.repository.MemberRepository
import org.hhplus.lecture.infra.persistence.convertor.MemberConvertor
import org.hhplus.lecture.infra.persistence.jpa.JpaMemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val jpaMemberRepository: JpaMemberRepository,
    private val memberConvertor: MemberConvertor
) : MemberRepository {

    override fun save(memberDomain: MemberDomain): MemberDomain {
        val entity = memberConvertor.toEntity(memberDomain)
        val saved = jpaMemberRepository.save(entity)
        return memberConvertor.toDomain(saved)
    }

    override fun findById(id: Long): MemberDomain? {
        val member = jpaMemberRepository.findByIdOrNull(id)
        return member?.let { memberConvertor.toDomain(it) }
    }

}