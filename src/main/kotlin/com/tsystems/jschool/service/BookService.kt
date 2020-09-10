package com.tsystems.jschool.service

import com.tsystems.jschool.dao.BookDao
import com.tsystems.jschool.model.BookDto
import com.tsystems.jschool.util.toBook
import com.tsystems.jschool.util.toBookDto
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