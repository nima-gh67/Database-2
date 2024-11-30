package khoshi.amin.sqlite.model.repository

import khoshi.amin.sqlite.model.BookModel
import khoshi.amin.sqlite.model.dao.DatabaseDao

class DbRepositoryImpl(
    private val dao: DatabaseDao.Dao
) : DbRepository {
    override suspend fun getBooks(): List<BookModel> {
        return dao.getBooks()
    }

    override suspend fun addBook(bookModel: BookModel): Long {
        return dao.addBook(bookModel)
    }
}