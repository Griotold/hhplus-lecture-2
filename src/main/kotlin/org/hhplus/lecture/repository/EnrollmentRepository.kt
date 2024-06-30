package org.hhplus.lecture.repository

import org.hhplus.lecture.domain.Enrollment

interface EnrollmentRepository {
    fun findAllByStudentId(studentId: Long): List<Enrollment>

    fun save(enrollment: Enrollment): Enrollment

    fun deleteAll()
}