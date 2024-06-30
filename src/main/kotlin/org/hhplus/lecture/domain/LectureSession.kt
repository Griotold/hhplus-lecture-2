package org.hhplus.lecture.domain

import org.hhplus.lecture.exception.AlreadyEnrolledException
import org.hhplus.lecture.exception.CapacityExceededException
import org.hhplus.lecture.exception.PeriodOverlapException
import org.hhplus.lecture.exception.OutOfPeriodException
import java.time.LocalDateTime

class LectureSession (
    val id: Long,
    val lecture: Lecture,
    val capacity: Int,
    availableCapacity: Int, // var 또는 val 이 붙지 않으면 프로퍼티가 되지 않는다.
    val enrollmentPeriod: DateTimeRange,
    val lecturePeriod: DateTimeRange
){
    var availableCapacity: Int = availableCapacity // 수용 가능 인원
        private set

    private var enrollments: MutableList<Enrollment> = arrayListOf() // 수강 완료 정보

    init {
        if (enrollmentPeriod.overlaps(lecturePeriod))
            throw PeriodOverlapException("신청 기관과 강의 시간을 겹칠 수 없습니다.")
    }

    fun addEnrollments(enrollments: List<Enrollment>) {
        this.enrollments.addAll(enrollments)
    }

    fun enroll(student: Student, at: LocalDateTime): Enrollment {
        checkEnrollmentPeriod(at)
        checkEnrollments(student)
        checkAvailableCapacity()

        availableCapacity--

        // also 함수 = 객체를 받아서 객체를 변형하지는 않고 추가 작업만 수행
        // Enrollment 객체를 생성한 후에 그 객체를 enrollments에 추가
        return Enrollment(
            id = 0L,
            student = student,
            lectureSession = this,
            enrolledAt = at
        ).also {
            enrollments.add(it)
        }
    }

    private fun checkEnrollmentPeriod(moment: LocalDateTime) {
        if (!enrollmentPeriod.contains(moment))
            throw OutOfPeriodException("현재는 신청 기한이 아닙니다.")
    }

    private fun checkEnrollments(student: Student) {
        // any 함수는 스트림이라고 생각하면 된다.
        val alreadyEnrolled = enrollments.any { it.student == student}
        if (alreadyEnrolled)
            throw AlreadyEnrolledException("이미 신청 완료한 강의입니다.")
    }

    private fun checkAvailableCapacity() {
        if (availableCapacity == 0)
            throw CapacityExceededException("정원이 마감된 강의입니다.")
    }
}