package org.hhplus.lecture.infra

import org.hhplus.lecture.infra.entity.EnrollmentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EnrollmentJpaRepository : JpaRepository<EnrollmentEntity, Long>{
    fun findAllByStudentId(studentId: Long): List<EnrollmentEntity>
}