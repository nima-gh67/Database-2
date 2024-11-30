package khoshi.amin.sqlite.model.dao

import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import khoshi.amin.sqlite.model.BookModel

@Database(
    entities = [BookModel::class],
    version = 1
)
abstract class DatabaseDao : RoomDatabase() {
    abstract val dao: Dao

    @androidx.room.Dao
    interface Dao {
        @Query("SELECT * FROM book")
        suspend fun getBooks(): List<BookModel>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun addBook(bookModel: BookModel): Long
    }
}