package com.tsystems.jschoolkotlin.service

import com.tsystems.jschoolkotlin.dao.UserDao
import com.tsystems.jschoolkotlin.exception.IdInvalidException
import com.tsystems.jschoolkotlin.model.ChangeUserBooksRequest
import com.tsystems.jschoolkotlin.model.CreateUserRequest
import com.tsystems.jschoolkotlin.util.toUUID
import com.tsystems.jschoolkotlin.util.toUser
import com.tsystems.jschoolkotlin.util.toUserDto
import com.tsystems.jschoolkotlin.util.validateEmail
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

typealias Action = ChangeUserBooksRequest.Action

@Service
class UserService(
    private val userDao: UserDao,
    private val bookService: BookService
) {

    var logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getAll() = userDao.getAll().map { it.toUserDto() }

    fun getById(userId: UUID) =
        userDao.findBy { it.id == userId }.firstOrNull()

    fun addUser(request: CreateUserRequest) = userDao.addUser(
        request
            .also { it.email.validateEmail() }
            .toUser()
    )

    fun changeUserBooks(userId: String, userBooksRequest: ChangeUserBooksRequest) =
        userBooksRequest.stateBooks.forEach { bookState ->
            try {
                bookService.getById(bookState.bookId.toUUID())?.let { book ->
                    {
                        getById(userId.toUUID())?.let {
                            when (bookState.action) {
                                Action.ADD -> {
                                    it.books.plusElement(book)
                                }
                                Action.DELETE ->
                                    it.books.minusElement(book)
                            }
                        }

                    }
                }
            } catch (ex: IdInvalidException) {
                logger.warn(ex.message)
            }
        }


}

