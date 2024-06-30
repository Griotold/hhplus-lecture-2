package org.hhplus.lecture.infra.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "enrollment",
    uniqueConstraints = [UniqueConstraint(columnNames = ["lecture_session_id", "student_id"])]
)
class EnrollmentEntity (
    id: Long,
    studentEntity: StudentEntity,
    lectureSessionEntity: LectureSessionEntity,
    enrolledAt: LocalDateTime,
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Student_id")
    var student: StudentEntity = studentEntity
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_session_id")
    var lectureSession: LectureSessionEntity = lectureSessionEntity
        private set

    var enrolledAt: LocalDateTime = enrolledAt
        private set
}