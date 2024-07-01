package org.hhplus.lecture.infra

import org.hhplus.lecture.domain.Student
import org.hhplus.lecture.infra.entity.StudentEntity
import org.hhplus.lecture.repository.StudentRepository
import org.springframework.stereotype.Repository

@Repository
class StudentRepositoryImpl (
    private val jpaRepository: StudentJpaRepository
) : StudentRepository {
    override fun findOneById(id: Long): Student? =
        jpaRepository.findById(id)
            .map { it.toStudent() }
            .orElse(null)

    override fun save(student: Student): Student =
        jpaRepository.save(student.toEntity()).toStudent()

    override fun deleteAll() =jpaRepository.deleteAll()
}

fun Student.toEntity(): StudentEntity = StudentEntity(id)

fun StudentEntity.toStudent(): Student = Student(id)