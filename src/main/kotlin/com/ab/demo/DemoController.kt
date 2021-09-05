package com.ab.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/hello")
class DemoController(@Value("\${envParam:noParamPassed}") val envValue: String) {

    @GetMapping
    fun hello(): Mono<String> {
        return Mono.just("hello. Evn param is $envValue")
    }

}