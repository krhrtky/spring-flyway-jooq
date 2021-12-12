package com.example.springflywayjooq.contorlloer

import nu.studer.sample.tables.AppUser.Companion.APP_USER
import nu.studer.sample.tables.pojos.AppUser
import org.jooq.DSLContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class IndexController(private val dsl: DSLContext) {
    @GetMapping("/")
    fun index(): String {

        val a = dsl.select().from(APP_USER).fetchOne()?.into(AppUser())
        val result = dsl.selectFrom(APP_USER).fetchOne()
        println(a)

        return result?.id.toString()
    }
}
