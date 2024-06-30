package org.hhplus.lecture.infra.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class StudentEntity(id: Long) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set
}