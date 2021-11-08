package com.ab.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/hello")
class DemoController(
    @Value("\${envParam:noParamPassed}") val envValue: String,
    val helloService: HelloService
) {
    @GetMapping("/envParam")
    fun getEnvParam() = envValue

    @GetMapping
    fun hello(): Mono<Greetings> {
        val paramMono = helloService.callRemoteEndpoint()
        return paramMono.map { Greetings(message = "hello. Evn param is $it") }
    }
}

data class Greetings(val message: String)

@RestController
@RequestMapping("/")
class DefaultController {

    @GetMapping
    fun healthCheck() = "I am alive"
}