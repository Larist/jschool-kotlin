package com.tsystems.jschoolkotlin.util

import com.tsystems.jschoolkotlin.exception.EmailInvalidException
import com.tsystems.jschoolkotlin.exception.IdInvalidException
import java.util.*

private val EMAIL_REGEX = """([a-zA-Z0-9._-]+)@(([a-zA-Z0-9_-]+\.)+[a-zA-Z]{2,})""".toRegex()

fun String.toUUID() = try {
    UUID.fromString(this)
} catch (ex: Exception) {
    throw IdInvalidException("Id $this is invalid")
}

fun String?.validateEmail() {
    if (!this.isNullOrBlank()) {
        EMAIL_REGEX.find(this)
            ?: throw EmailInvalidException("Email $this is invalid")
    }
}