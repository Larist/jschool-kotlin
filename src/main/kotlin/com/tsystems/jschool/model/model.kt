package com.tsystems.jschool.model

data class UserDto(
    val id: String,
    val fullName: String,
    val age: Int,
    val email: String,
    val books: List<BookDto>
)

data class BookDto(
    val id: String,
    val name: String,
    val author: String,
    val genre: String
)

data class CreateUserRequest(
    val name: String,
    val lastName: String,
    val age: Int,
    val email: String?
)

data class ChangeUserBooksRequest(val stateBooks: MutableList<BookState>) {
    class BookState(val action: Action, val bookId: String)
    enum class Action {
        DELETE,
        ADD
    }
}