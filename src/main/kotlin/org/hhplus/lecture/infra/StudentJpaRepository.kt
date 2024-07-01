package org.hhplus.lecture.infra

import org.hhplus.lecture.infra.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRepository : JpaRepository<StudentEntity, Long> {
}