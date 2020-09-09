package com.tsystems.jschoolkotlin.controller

import com.tsystems.jschoolkotlin.exception.NotFoundException
import com.tsystems.jschoolkotlin.model.ChangeUserBooksRequest
import com.tsystems.jschoolkotlin.model.CreateUserRequest
import com.tsystems.jschoolkotlin.service.UserService
import com.tsystems.jschoolkotlin.util.toUUID
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll() = userService.getAll()

    @GetMapping("{userId}")
    fun getById(@PathVariable userId: String) =
        userService.getById(userId.toUUID())
            ?: throw NotFoundException("User with id $userId not found")

    @PostMapping
    fun createUser(request: CreateUserRequest) {
        userService.addUser(request)
    }

    @PutMapping("{userId}/books")
    fun changeUserBooks(
        @PathVariable userId: String,
        @RequestBody request: ChangeUserBooksRequest
    ) = userService.changeUserBooks(userId, request)

}
