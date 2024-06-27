package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.ApplyDomain

interface ApplyRepository {
    fun save(applyDomain: ApplyDomain): ApplyDomain
    fun findById(id: Long): ApplyDomain?
}