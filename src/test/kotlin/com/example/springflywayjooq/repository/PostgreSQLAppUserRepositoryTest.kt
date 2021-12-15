package com.example.springflywayjooq.repository

import io.kotlintest.shouldNotBe
import java.util.*
import nu.studer.sample.tables.records.AppUserRecord
import nu.studer.sample.tables.references.APP_USER
import org.jooq.DSLContext
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PostgreSQLAppUserRepositoryTest(
    @Autowired private val dsl: DSLContext,
    @Autowired private val appUserRepository: AppUserRepository,
) {

    @BeforeEach
    fun setUp() {
        dsl
            .insertInto(APP_USER)
            .set(AppUserRecord(
                id =  UUID.fromString("4aea39d2-5b66-4c46-bb95-8a36b4ed2a35"),
            ))
            .execute()
    }

    @AfterEach
    fun tearDown() {
        dsl.deleteFrom(APP_USER).execute()
    }

    @Test
    fun findBy() {
        val result = appUserRepository.findBy(id =  "4aea39d2-5b66-4c46-bb95-8a36b4ed2a35")

        result shouldNotBe null
    }
}
