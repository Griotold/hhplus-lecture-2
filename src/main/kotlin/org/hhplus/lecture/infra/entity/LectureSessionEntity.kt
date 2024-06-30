package org.hhplus.lecture.infra.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity
@Table(
    name = "lecture_session",
    uniqueConstraints = [UniqueConstraint(columnNames = ["lecture_id", "lecture_date"])]
)
class LectureSessionEntity (
    id: Long,
    lecture: LectureEntity,
    capacity: Int,
    availableCapacity: Int,
    lectureDate: LocalDate,
    lectureStartTime: LocalTime,
    lectureEndTime: LocalTime,
    enrollmentPeriodStart: LocalDateTime,
    enrollmentPeriodEnd: LocalDateTime,
    ){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    var lecture: LectureEntity = lecture
        private set

    var capacity: Int = capacity
        private set

    var availableCapacity: Int = availableCapacity
        private set

    var lectureDate: LocalDate = lectureDate
        private set

    var lectureStartTime: LocalTime = lectureStartTime
        private set

    var lectureEndTime: LocalTime = lectureEndTime
        private set

    var enrollmentPeriodStart: LocalDateTime = enrollmentPeriodStart
        private set

    var enrollmentPeriodEnd: LocalDateTime = enrollmentPeriodEnd
        private set
}