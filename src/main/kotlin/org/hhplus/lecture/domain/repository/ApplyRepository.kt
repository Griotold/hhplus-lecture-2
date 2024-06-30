package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.ApplyDomain
import org.hhplus.lecture.domain.MemberDomain
import org.hhplus.lecture.domain.ScheduleDomain

interface ApplyRepository {
    fun save(memberDomain: MemberDomain, scheduleDomain: ScheduleDomain): ApplyDomain
    fun findById(id: Long): ApplyDomain?
}