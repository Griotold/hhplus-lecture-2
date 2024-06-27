package org.hhplus.lecture.application.service

import org.hhplus.lecture.application.request.ApplyRequest
import org.hhplus.lecture.application.response.ApplyResponse
import org.hhplus.lecture.domain.constant.ApplyStatus
import org.hhplus.lecture.infra.persistence.entity.Apply
import org.hhplus.lecture.domain.repository.ApplyRepository
import org.hhplus.lecture.domain.repository.LectureRepository
import org.hhplus.lecture.domain.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ApplyService(
    private val applyRepository: ApplyRepository,
    private val memberRepository: MemberRepository,
    private val lectureRepository: LectureRepository
){
    @Transactional
    fun apply(applyRequest: ApplyRequest): ApplyResponse? {
//        val member = memberRepository.findById(applyRequest.memberId)
//            ?: throw IllegalArgumentException("There is no member with the id ${applyRequest.memberId}")
//        val lecture = lectureRepository.findById(applyRequest.lectureId)
//            ?: throw IllegalArgumentException("There is no lecture with the id ${applyRequest.lectureId}")
//        val apply = Apply(
//            member = member,
//            lecture = lecture,
//            applyStatus = ApplyStatus.SUCCESS
//        )
//        val saved = applyRepository.save(apply)
//        return ApplyResponse(
//            memberId = saved.member.id!!,
//            lectureId = saved.lecture.id!!,
//            applyStatus = saved.applyStatus.toString())
        return null
    }
}