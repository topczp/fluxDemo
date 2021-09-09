package com.ab.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

    @Autowired
    @Value("\${envParam}")
    lateinit var propertyFromConfig: String

//    @Autowired
//    @Value("\${spring.profiles.active}")
//    lateinit var activeProfile: String

    @Autowired
    lateinit var environment: Environment

    @Test
    fun contextLoads() {
        assertThat(propertyFromConfig).isEqualTo("overridden in test")
        val activeProfileFromEnvironment = environment.activeProfiles[0]
        assertThat(activeProfileFromEnvironment).isEqualTo("test")
//        assertThat(activeProfile).isEqualTo("from application properties")
    }

}
