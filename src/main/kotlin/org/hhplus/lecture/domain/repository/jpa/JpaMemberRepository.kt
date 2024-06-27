package org.hhplus.lecture.domain.repository.jpa

import org.hhplus.lecture.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface JpaMemberRepository : JpaRepository<Member, Long> {
}