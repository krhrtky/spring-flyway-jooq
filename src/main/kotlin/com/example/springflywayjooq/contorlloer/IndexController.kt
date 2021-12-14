package com.example.springflywayjooq.contorlloer

import com.example.springflywayjooq.repository.AppUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class IndexController(
    private val appUserRepository: AppUserRepository,
) {
    @GetMapping("/")
    fun index(): String {

        val result = appUserRepository.take()

        return result?.id.toString()
    }
}
