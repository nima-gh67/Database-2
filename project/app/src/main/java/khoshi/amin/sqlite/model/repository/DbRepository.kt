package khoshi.amin.sqlite.model.repository

import khoshi.amin.sqlite.model.BookModel

interface DbRepository {
    suspend fun getBooks(): List<BookModel>
    suspend fun addBook(bookModel: BookModel): Long
}