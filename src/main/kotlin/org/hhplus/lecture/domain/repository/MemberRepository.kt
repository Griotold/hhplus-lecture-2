package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.MemberDomain

interface MemberRepository {
    fun save(memberDomain: MemberDomain): MemberDomain
    fun findById(id: Long): MemberDomain?
}