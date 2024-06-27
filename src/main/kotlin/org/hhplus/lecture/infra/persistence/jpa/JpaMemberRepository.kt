package org.hhplus.lecture.infra.persistence.jpa

import org.hhplus.lecture.infra.persistence.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface JpaMemberRepository : JpaRepository<Member, Long> {
}