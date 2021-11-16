
package com.ab.demo

import org.springframework.data.repository.CrudRepository;
import com.ab.demo.VisitKt;
import org.springframework.stereotype.Service
import org.springframework.dao.DataAccessException;

interface VisitRepo: CrudRepository<VisitKt, Long> {
    @Throws(DataAccessException::class)
    fun save(var1: VisitKt) : VisitKt { return var1 } ;
}