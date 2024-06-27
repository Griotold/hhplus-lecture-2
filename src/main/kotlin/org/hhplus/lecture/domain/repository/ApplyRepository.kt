package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.entity.Apply

interface ApplyRepository {
    fun save(apply: Apply): Apply
    fun findById(id: Long): Apply?
}