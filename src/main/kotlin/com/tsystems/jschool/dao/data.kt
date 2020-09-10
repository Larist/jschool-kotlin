package com.tsystems.jschool.dao

import com.tsystems.jschool.entity.Book
import com.tsystems.jschool.entity.Genre
import com.tsystems.jschool.entity.User

val harryPotter = Book("Harry Potter", "J. K. Rowling", Genre.FANTASY)
val hisDarkMaterials = Book("His Dark Materials", "Philip Pullman", Genre.FANTASY)
val sherlock = Book("Sherlock Holmes", "Sir Arthur Ignatius Conan Doyle", Genre.DETECTIVE)
val shining = Book("The Shining", "Stephen Edwin King", Genre.HORROR)
val goodYear = Book("A Good Year", "Peter Mayle")

val andrey = User(
    "Andrey",
    "Laristov",
    29,
    mutableSetOf(harryPotter, hisDarkMaterials, goodYear)
)

val konstantin = User(
    name = "Konstantin",
    lastName = "Konstantinov",
    age = 30,
    books = mutableSetOf(sherlock, shining),
    email = "Konstantinov@mail.ru"
)

val aleksey = User(
    "Aleksey",
    "Bashkatov",
    100500,
    mutableSetOf()
)