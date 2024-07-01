package org.hhplus.lecture.infra

import org.hhplus.lecture.domain.Lecture
import org.hhplus.lecture.infra.entity.LectureEntity
import org.hhplus.lecture.repository.LectureRepository
import org.springframework.stereotype.Repository

@Repository
class LectureRepositoryImpl (
    private val jpaRepository: LectureJpaRepository
) : LectureRepository {
    override fun findOneById(id: Long): Lecture? =
        jpaRepository.findById(id).map {it.toLecture() }.orElse(null)

    override fun save(lecture: Lecture): Lecture =
        jpaRepository.save(lecture.toEntity()).toLecture()

    override fun deleteAll() = jpaRepository.deleteAll()
}

fun Lecture.toEntity(): LectureEntity = LectureEntity(
    id = id,
    name = name,
    instructorName = instructorName
)

fun LectureEntity.toLecture(): Lecture = Lecture(
    id = id,
    name = name,
    instructorName = instructorName,
)