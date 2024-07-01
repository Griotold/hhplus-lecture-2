package org.hhplus.lecture.service

import org.hhplus.lecture.domain.LectureSession
import org.hhplus.lecture.exception.LectureSessionNotFoundException
import org.hhplus.lecture.exception.StudentNotFoundException
import org.hhplus.lecture.repository.EnrollmentRepository
import org.hhplus.lecture.repository.LectureSessionRepository
import org.hhplus.lecture.repository.StudentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class LectureSessionService (
    private val studentRepository: StudentRepository,
    private val sessionRepository: LectureSessionRepository,
    private val enrollmentRepository: EnrollmentRepository,
){
    fun enroll(lectureSessionId: Long, studentId: Long): LectureSession {
        val session = sessionRepository.findOneById(lectureSessionId) ?: throw LectureSessionNotFoundException()
        val student = studentRepository.findOneById(studentId) ?: throw StudentNotFoundException()

        enrollmentRepository.findAllByStudentId(student.id).also {
            session.addEnrollments(it)
        }

        val at = LocalDateTime.now()
        val enrollment = session.enroll(student, at)
        enrollmentRepository.save(enrollment)

        return sessionRepository.save(session)
    }
}