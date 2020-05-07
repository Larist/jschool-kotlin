package com.tsystems.jschoolkotlin.service

import com.tsystems.jschoolkotlin.dao.BookDao
import com.tsystems.jschoolkotlin.model.BookDto
import com.tsystems.jschoolkotlin.util.toBook
import com.tsystems.jschoolkotlin.util.toBookDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookDao: BookDao) {

    fun getById(bookId: UUID) = bookDao
        .findBy { it.id == bookId }
        .map { it.toBookDto() }
        .firstOrNull()

    fun getAll() = bookDao.getAll()

    fun getByAuthor(author: String) = bookDao.findBy { it.author == author }

    fun addBook(bookDto: BookDto) = bookDao.addBook(bookDto.toBook())
}