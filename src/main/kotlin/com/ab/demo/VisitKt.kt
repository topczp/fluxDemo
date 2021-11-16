package com.ab.demo
import javax.persistence.*
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
data class VisitKt(

	@Column(name = "visit_date")
	var visit_date: Date?,

	@Column(name = "description")
	var description: String = "",
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)
