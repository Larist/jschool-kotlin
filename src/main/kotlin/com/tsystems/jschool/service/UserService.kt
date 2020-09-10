package com.tsystems.jschool.service

import com.tsystems.jschool.dao.BookDao
import com.tsystems.jschool.dao.UserDao
import com.tsystems.jschool.exception.IdInvalidException
import com.tsystems.jschool.model.ChangeUserBooksRequest
import com.tsystems.jschool.model.CreateUserRequest
import com.tsystems.jschool.util.toUUID
import com.tsystems.jschool.util.toUser
import com.tsystems.jschool.util.toUserDto
import com.tsystems.jschool.util.validateEmail
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

typealias Action = ChangeUserBooksRequest.Action

@Service
class UserService(
    private val userDao: UserDao,
    private val bookDao: BookDao
) {

    val logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getAll() = userDao.getAll().map { it.toUserDto() }

    fun getById(userId: UUID) =
        userDao.findBy { it.id == userId }
            .map { it.toUserDto() }
            .firstOrNull()

    fun addUser(request: CreateUserRequest) = userDao.addUser(
        request
            .also { it.email.validateEmail() }
            .toUser()
    )

    fun changeUserBooks(userId: String, userBooksRequest: ChangeUserBooksRequest) =
        userBooksRequest.stateBooks.forEach { bookState ->
            try {
                bookDao.findBy { it.id == bookState.bookId.toUUID() }.firstOrNull()?.let { book ->
                    userDao.findBy { it.id == userId.toUUID() }.firstOrNull()?.let { user ->
                        when (bookState.action) {
                            Action.ADD -> {
                                user.books.add(book)
                            }
                            Action.DELETE ->
                                user.books.remove(book)
                        }
                    }
                }
            } catch (ex: IdInvalidException) {
                logger.warn(ex.message)
            }
        }
}

