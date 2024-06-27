package org.hhplus.lecture.domain.repository

import org.hhplus.lecture.domain.entity.Apply
import org.hhplus.lecture.domain.entity.Lecture

interface LectureRepository {
    fun save(lecture: Lecture): Lecture
    fun findById(id: Long): Lecture?
}