package org.hhplus.lecture.api

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.*
import org.hhplus.lecture.application.request.ApplyRequest
import org.hhplus.lecture.infra.persistence.entity.Lecture
import org.hhplus.lecture.infra.persistence.entity.Member
import org.hhplus.lecture.infra.persistence.jpa.JpaLectureRepository
import org.hhplus.lecture.infra.persistence.jpa.JpaMemberRepository
import org.json.JSONObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime

@SpringBootTest
@AutoConfigureMockMvc
class ApplyControllerTest (
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val jpaMemberRepository: JpaMemberRepository,
    @Autowired private val jpaLectureRepository: JpaLectureRepository,
    @Autowired private val em: EntityManager
) {

    private fun performPost(uri: String, applyRequest: ApplyRequest): MvcResult {
        val requestBody = objectMapper.writeValueAsString(applyRequest)
        return mockMvc
            .perform(
                MockMvcRequestBuilders.post(uri)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
    }
    @Transactional
    @BeforeEach
    fun setup() {
        em.createNativeQuery("ALTER TABLE member ALTER COLUMN id RESTART WITH 1").executeUpdate()
        em.createNativeQuery("ALTER TABLE lecture ALTER COLUMN id RESTART WITH 1").executeUpdate()
        jpaMemberRepository.deleteAll()
        jpaLectureRepository.deleteAll()

        val members = listOf(
            Member(name = "Member 1"),
            Member(name = "Member 2"),
            Member(name = "Member 3")
        )
        jpaMemberRepository.saveAll(members)

        // Add lectures
        val lectures = listOf(
            Lecture(title = "Lecture 1", apply_start_at = LocalDateTime.now(), lecture_start_at = LocalDateTime.now(), capacity = 30, current_applicants = 0),
        )
        jpaLectureRepository.saveAll(lectures)
    }

    @Test
    fun `수강신청하기 성공`() {
        // given
        val uri = "/lectures/apply"
        val ApplyRequest = ApplyRequest(memberId = 1L, lectureId = 1L)

        // when
        val mvcResult = performPost(uri = uri, applyRequest = ApplyRequest)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)

        // then
        val jsonResponse = JSONObject(contentAsString)
        val memberId = jsonResponse.getLong("memberId")
        val lectureId = jsonResponse.getLong("lectureId")
        val applyStatus = jsonResponse.getString("applyStatus")

        assertThat(memberId).isEqualTo(1L)
        assertThat(lectureId).isEqualTo(1L)
        assertThat(applyStatus).isEqualTo("SUCCESS")
    }

    @Test
    fun `수강신청하기 성공 - 일반화 시키기`() {
        // given
        val uri = "/lectures/apply"
        val ApplyRequest = ApplyRequest(memberId = 2L, lectureId = 2L)

        // when
        val mvcResult = performPost(uri = uri, applyRequest = ApplyRequest)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)

        // then
        val jsonResponse = JSONObject(contentAsString)
        val memberId = jsonResponse.getLong("memberId")
        val lectureId = jsonResponse.getLong("lectureId")
        val applyStatus = jsonResponse.getString("applyStatus")

        assertThat(memberId).isEqualTo(2L)
        assertThat(lectureId).isEqualTo(2L)
        assertThat(applyStatus).isEqualTo("SUCCESS")
    }
}