package org.hhplus.lecture.controller

import org.hhplus.lecture.controller.dto.ApplicationRequest
import org.hhplus.lecture.controller.dto.LectureSessionDto
import org.hhplus.lecture.service.LectureSessionService
import org.hhplus.lecture.controller.dto.Result
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture-sessions")
class LectureSessionController (
    private val lectureSessionService: LectureSessionService
){
    @PostMapping("{sessionId}/apply")
    fun enroll(
        @PathVariable("sessionId") sessionId: Long,
        @RequestBody req: ApplicationRequest
    ) : Result<LectureSessionDto>{
        return Result(LectureSessionDto.from(lectureSessionService.enroll(sessionId, req.studentId)))
    }
}