package com.ab.demo

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@WebFluxTest(DemoController::class)
class DemoControllerTest {
    val paramValue = "DemoControllerTest"

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var helloService: HelloService


    @Test
    internal fun testHelloWorldEndpoint() {
        Mockito.`when`(helloService.callRemoteEndpoint()).thenReturn(Mono.just(paramValue))
        webTestClient.get()
            .uri("/hello")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.message").isEqualTo("hello. Evn param is $paramValue")
    }
}