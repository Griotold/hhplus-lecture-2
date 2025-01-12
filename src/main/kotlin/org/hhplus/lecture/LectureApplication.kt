package org.hhplus.lecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LectureApplication

fun main(args: Array<String>) {
    runApplication<LectureApplication>(*args)
}
