package com.tsystems.jschoolkotlin.util

import com.tsystems.jschoolkotlin.entity.Book
import com.tsystems.jschoolkotlin.entity.Genre
import com.tsystems.jschoolkotlin.entity.User
import com.tsystems.jschoolkotlin.model.BookDto
import com.tsystems.jschoolkotlin.model.CreateUserRequest
import com.tsystems.jschoolkotlin.model.UserDto

fun User.toUserDto() = UserDto(
    "$name $lastName",
    age,
    email ?: "has no email",
    books.map { it.toBookDto() }
)

fun Book.toBookDto() = BookDto(
    name,
    author,
    genre.value
)

fun CreateUserRequest.toUser() =
    User(
        name,
        lastName,
        age,
        email = email
    )


fun BookDto.toBook() = Book(name, author, Genre.valueOf(genre))