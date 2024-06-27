package org.hhplus.lecture.domain.repository.impl

import org.hhplus.lecture.domain.entity.Lecture
import org.hhplus.lecture.domain.repository.LectureRepository
import org.hhplus.lecture.domain.repository.jpa.JpaLectureRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class LectureRepositoryImpl(
    private val jpaLectureRepository: JpaLectureRepository
) : LectureRepository {
    override fun save(lecture: Lecture): Lecture {
        return jpaLectureRepository.save(lecture)
    }

    override fun findById(id: Long): Lecture? {
        return jpaLectureRepository.findByIdOrNull(id)
    }
}