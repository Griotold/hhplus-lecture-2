package org.hhplus.lecture.domain

import org.hhplus.lecture.exception.InvalidDateRangeException
import java.time.LocalDateTime

data class DateTimeRange (
    val start: LocalDateTime,
    val end: LocalDateTime
) {
    init {
        if (start.isAfter(end))
            throw InvalidDateRangeException("시작 시점은 끝 시점보다 앞서야 합니다.")
    }

    /**
     * 한 시점(moment)이 start <= moment <= end 인지를 반환
     * */
//    fun contains(moment: LocalDateTime): Boolean =
//        if (moment.isBefore(start))
//            false
//        else if (moment.isAfter(end))
//            false
//        else
//            true

    // 리팩토링 - when 표현식
    fun contains(moment: LocalDateTime): Boolean =
        when {
            moment.isBefore(start) -> false
            moment.isAfter(end) -> false
            else -> true
        }

    /**
     * 다른 DateTimeRange 와 겹치는 지를 반환
     * */
//    fun overlaps(other: DateTimeRange): Boolean =
//        if (end.isBefore(other.start))
//            false
//        else if (start.isAfter(other.end))
//            false
//        else
//            true

    // 리팩토링 - when 표현식
    fun overlaps(other: DateTimeRange): Boolean =
        when {
            end.isBefore(other.start) -> false
            start.isAfter(other.end) -> false
            else -> true
        }
}