package org.hhplus.lecture.infra

import org.hhplus.lecture.domain.DateTimeRange
import org.hhplus.lecture.domain.LectureSession
import org.hhplus.lecture.infra.entity.LectureSessionEntity
import org.hhplus.lecture.repository.LectureSessionRepository
import org.springframework.stereotype.Repository

@Repository
class LectureSessionRepositoryImpl(
    private val jpaRepository: LectureSessionJpaRepository
) : LectureSessionRepository {
    override fun findOneById(id: Long): LectureSession? =
        jpaRepository.findById(id).map { it.toLectureSession() }.orElse(null)

    override fun save(lectureSession: LectureSession): LectureSession =
        jpaRepository.save(lectureSession.toEntity()).toLectureSession()

    override fun deleteAll() = jpaRepository.deleteAll()
}

fun LectureSessionEntity.toLectureSession(): LectureSession {
    val lectureStartDateTime = lectureDate.atTime(lectureStartTime)
    val lectureEndDateTime = lectureDate.atTime(lectureEndTime)
    return LectureSession(
        id = id,
        lecture = lecture.toLecture(),
        capacity = capacity,
        availableCapacity = availableCapacity,
        lecturePeriod = DateTimeRange(lectureStartDateTime, lectureEndDateTime),
        enrollmentPeriod = DateTimeRange(enrollmentPeriodStart, enrollmentPeriodEnd)
    )
}

fun LectureSession.toEntity(): LectureSessionEntity = LectureSessionEntity(
    id = id,
    lecture = lecture.toEntity(),
    capacity = capacity,
    availableCapacity = availableCapacity,
    lectureDate = lecturePeriod.start.toLocalDate(),
    lectureStartTime = lecturePeriod.start.toLocalTime(),
    lectureEndTime = lecturePeriod.end.toLocalTime(),
    enrollmentPeriodStart = enrollmentPeriod.start,
    enrollmentPeriodEnd = enrollmentPeriod.end
)