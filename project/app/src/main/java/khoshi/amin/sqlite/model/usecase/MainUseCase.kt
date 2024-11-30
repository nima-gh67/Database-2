package khoshi.amin.sqlite.model.usecase

import khoshi.amin.sqlite.model.BookModel
import khoshi.amin.sqlite.model.repository.DbRepository

class MainUseCase(
    private val repository: DbRepository
) {
    suspend fun getBooks(): List<BookModel> {
        return repository.getBooks()
    }

    suspend fun addBook(bookModel: BookModel): Long {
        return repository.addBook(bookModel)
    }
}