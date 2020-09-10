package com.tsystems.jschool.controller

import com.tsystems.jschool.exception.NotFoundException
import com.tsystems.jschool.model.ChangeUserBooksRequest
import com.tsystems.jschool.model.CreateUserRequest
import com.tsystems.jschool.service.UserService
import com.tsystems.jschool.util.toUUID
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
