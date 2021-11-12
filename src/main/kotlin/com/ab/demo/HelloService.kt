package com.ab.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class HelloService(@Value("\${forwardUrl:http://localhost:8080}") forwardUrl: String) {
    var client: WebClient = WebClient.create(forwardUrl)

    fun callRemoteEndpoint(): Mono<String> {
        return client.get()
            .uri("/hello/envParam")
            .retrieve()
            .bodyToMono(String::class.java)
    }

}