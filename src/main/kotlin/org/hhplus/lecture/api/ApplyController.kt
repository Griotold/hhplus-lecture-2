package org.hhplus.lecture.api

import org.hhplus.lecture.application.request.ApplyRequest
import org.hhplus.lecture.application.response.ApplyResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lectures")
class ApplyController {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/apply")
    fun apply(
    @RequestBody dto: ApplyRequest,
    ): ApplyResponse {
        return ApplyResponse(
            memberId = 1L,
            lectureId = 1L,
            applyStatus = "SUCCESS",
        )
    }
}