package org.hhplus.lecture.repository

import org.hhplus.lecture.domain.Student

interface StudentRepository {

    fun findOneById(id: Long): Student?

    fun save(student: Student): Student

    fun deleteAll()
}