package org.hhplus.lecture.exception

open class NotFoundException(entityName: String) : LectureEnrollmentException("해당 ${entityName}이 없습니다.")

class StudentNotFoundException: NotFoundException("학생")

class LectureSessionNotFoundException : NotFoundException("특강 세션")
