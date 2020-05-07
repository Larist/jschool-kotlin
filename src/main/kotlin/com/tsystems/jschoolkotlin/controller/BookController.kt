package com.tsystems.jschoolkotlin.controller

import com.tsystems.jschoolkotlin.exception.NotFoundException
import com.tsystems.jschoolkotlin.model.BookDto
import com.tsystems.jschoolkotlin.service.BookService
import com.tsystems.jschoolkotlin.util.toUUID
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