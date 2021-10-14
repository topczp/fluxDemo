package com.ab.demo.health

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.ReactiveHealthIndicator
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import kotlin.random.Random

@Component
class DownstreamServiceHealthIndicator : ReactiveHealthIndicator {
    override fun health(): Mono<Health> {
        return checkDownstreamServiceHealth().onErrorResume {
            Mono.just(
                Health.Builder().down(it).build()
            )
        }
    }

    private fun checkDownstreamServiceHealth(): Mono<Health> {
        return Mono.fromRunnable { checkHealth() }
    }

    private fun checkHealth(): Health {
        if (Random.nextDouble() > 0.9) {
            throw IllegalStateException("random failure")
        }
        return Health.Builder().build()
    }
}