package com.example.springflywayjooq.repository

interface AppUserRepository {
    fun findBy(id: String): AppUser?
    fun take(): AppUser?
}
