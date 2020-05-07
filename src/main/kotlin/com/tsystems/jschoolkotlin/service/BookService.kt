package com.tsystems.jschoolkotlin.service

import com.tsystems.jschoolkotlin.dao.BookDao
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookDao: BookDao) {
    fun getById(id: UUID) = bookDao.findBy { it.id == id }
        .firstOrNull()
}