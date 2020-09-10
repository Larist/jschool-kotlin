package com.tsystems.jschool.controller

import com.tsystems.jschool.exception.NotFoundException
import com.tsystems.jschool.model.BookDto
import com.tsystems.jschool.service.BookService
import com.tsystems.jschool.util.toUUID
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun searchBooks(@RequestParam author: String?) =
        if (author.isNullOrBlank())
            bookService.getAll()
        else
            bookService.getByAuthor(author)

    @GetMapping("{bookId}")
    fun getById(@PathVariable bookId: String) =
        bookService.getById(bookId.toUUID())
            ?: throw NotFoundException("Book with id $bookId not found")

    @PostMapping
    fun createBook(book: BookDto) = bookService.addBook(book)

}