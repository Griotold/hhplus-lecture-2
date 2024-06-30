package org.hhplus.lecture.repository

import org.hhplus.lecture.domain.Lecture

interface LectureRepository {
    fun findOneById(id: Long): Lecture?

    fun save(lecture: Lecture): Lecture

    fun deleteAll()
}