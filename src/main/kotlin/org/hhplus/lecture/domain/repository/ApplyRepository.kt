package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.infra.persistence.entity.Apply

interface ApplyRepository {
    fun save(apply: Apply): Apply
    fun findById(id: Long): Apply?
}