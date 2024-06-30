package org.hhplus.lecture.repository

import org.hhplus.lecture.domain.LectureSession

interface LectureSessionRepository {

    fun findOneById(id: Long): LectureSession?

    fun save(lectureSession: LectureSession): LectureSession

    fun deleteAll()
}