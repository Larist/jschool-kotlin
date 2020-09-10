package com.tsystems.jschool.dao

import com.tsystems.jschool.entity.Book
import org.springframework.stereotype.Repository

@Repository
class BookDao {

    private val books = mutableSetOf(harryPotter, hisDarkMaterials, sherlock, shining, goodYear)

    fun addBook(book: Book) = books.add(book)

    fun getAll() = books as Set<Book>

    fun findBy(predicate: (Book) -> Boolean) =
        books.filter(predicate)
}