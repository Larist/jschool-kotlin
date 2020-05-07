package com.tsystems.jschoolkotlin.controller

import com.tsystems.jschoolkotlin.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/books")
class BookController(private val bookService: BookService) {
    
}