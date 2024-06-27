package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.infra.persistence.entity.Lecture

interface LectureRepository {
    fun save(lecture: Lecture): Lecture
    fun findById(id: Long): Lecture?
}