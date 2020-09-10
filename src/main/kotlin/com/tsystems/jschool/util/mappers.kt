package com.tsystems.jschool.util

import com.tsystems.jschool.entity.Book
import com.tsystems.jschool.entity.Genre
import com.tsystems.jschool.entity.User
import com.tsystems.jschool.model.BookDto
import com.tsystems.jschool.model.CreateUserRequest
import com.tsystems.jschool.model.UserDto

fun User.toUserDto() = UserDto(
    id.toString(),
    "$name $lastName",
    age,
    email ?: "has no email",
    books.map { it.toBookDto() }
)

fun Book.toBookDto() = BookDto(
    id.toString(),
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