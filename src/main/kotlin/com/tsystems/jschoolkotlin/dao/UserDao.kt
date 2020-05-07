package com.tsystems.jschoolkotlin.dao

import com.tsystems.jschoolkotlin.entity.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserDao {

    private val users = mutableSetOf(andrey, aleksey, konstantin)

    fun addUser(user: User) = users.add(user)

    fun deleteUserById(id: UUID) = users.removeIf { it.id == id }

    fun getAll() = users as Set<User>

    fun findBy(predicate: (User) -> Boolean) =
        users.filter(predicate)

}