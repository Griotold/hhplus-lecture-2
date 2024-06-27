package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.entity.Member

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
}