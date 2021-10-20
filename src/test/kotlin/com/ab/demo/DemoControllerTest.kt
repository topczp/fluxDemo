package com.ab.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(DemoController::class)
class DemoControllerTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    internal fun testHelloWorldEndpoint() {
        webTestClient.get()
            .uri("/hello")
            .exchange()
            .expectStatus().isOk
    }
}