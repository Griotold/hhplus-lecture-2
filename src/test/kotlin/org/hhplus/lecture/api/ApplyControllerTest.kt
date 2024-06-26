package org.hhplus.lecture.api

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.security.auth.message.callback.SecretKeyCallback.AliasRequest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.hhplus.lecture.application.request.ApplyRequest
import org.json.JSONObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.nio.charset.StandardCharsets

@SpringBootTest
@AutoConfigureMockMvc
class ApplyControllerTest (
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper
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
}