package org.hhplus.lecture.infra.persistence.convertor

import org.hhplus.lecture.domain.MemberDomain
import org.hhplus.lecture.infra.persistence.entity.Member
import org.springframework.stereotype.Component

@Component
class MemberConvertor {

    fun toEntity(memberDomain: MemberDomain): Member {
        return Member(name = memberDomain.name)
    }

    fun toDomain(member: Member): MemberDomain {
        return MemberDomain(id = member.id!!, name = member.name)
    }
}