package com.ab.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.*
import java.util.Date;

import com.ab.demo.VisitKt;

@RestController
@RequestMapping("/")
class DemoController {

    @Autowired
    lateinit var repository: VisitRepo

	@GetMapping("/hello")
	fun findAll() : String {
        repository.save(VisitKt(id = 0, visit_date = Date()));
         return  "I am alive. Visits so far: " + repository.count() 
    };
}