package com.example.springflywayjooq.repository

import java.util.UUID
import nu.studer.sample.tables.AppUser.Companion.APP_USER
import nu.studer.sample.tables.pojos.AppUser as Pojo
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class PostgreSQLAppUserRepository(private val dsl: DSLContext) : AppUserRepository {
    override fun findBy(id: String): AppUser? =
        dsl
            .select()
            .from(APP_USER)
            .where(APP_USER.ID.eq(UUID.fromString(id)))
            .fetchOne()
            ?.into(Pojo())
            ?.let {
                AppUser(id = it.id.toString())
            }

    override fun take(): AppUser? =
        dsl
            .select()
            .from(APP_USER)
            .fetchOne()
            ?.into(Pojo())
            ?.let {
                AppUser(id = it.id.toString())
            }
}
