package khoshi.amin.sqlite.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookModel(
    @PrimaryKey(autoGenerate = true)
    var bookId: Long? = null,
    var content: String? = null,
    var date: Long? = null
)