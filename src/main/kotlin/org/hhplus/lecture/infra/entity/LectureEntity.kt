package org.hhplus.lecture.infra.entity

import jakarta.persistence.*

@Entity
@Table(name = "lecture")
class LectureEntity (
    id: Long,
    name: String,
    instructorName: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    var name: String = name
        private set

    var instructorName: String = instructorName
        private set
}