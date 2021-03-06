package com.tsystems.jschool.entity

import org.slf4j.LoggerFactory
import java.util.*
import kotlin.reflect.KClass

sealed class Entity

data class User(
    val name: String,
    val lastName: String,
    val age: Int,
    val books: MutableSet<Book> = mutableSetOf(),
    val email: String? = null,
    val id: UUID = randomUUIDAndLog(User::class)
) : Entity()

data class Book(
    val name: String,
    val author: String,
    val genre: Genre = Genre.ROMANCE,
    val id: UUID = randomUUIDAndLog(Book::class)
) : Entity()

enum class Genre(val value: String) {
    FANTASY("Fantasy"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    DETECTIVE("Detective")
}

private fun randomUUIDAndLog(clazz: KClass<out Entity>) = UUID.randomUUID().also {
    LoggerFactory.getLogger(clazz.java).debug("New instance of $clazz with uuid $it created")
}