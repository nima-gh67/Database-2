package khoshi.amin.sqlite.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import khoshi.amin.sqlite.model.BookModel
import khoshi.amin.sqlite.model.usecase.MainUseCase
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor(
    private val uc: MainUseCase
) : ViewModel() {

    var content = JSONObject()

    init {
        content.put("name", "")
    }

    fun addBook(onAdd: (profile: BookModel) -> Unit) {
        val bookModel = BookModel(
            bookId = null,
            content = content.toString(),
            date = System.currentTimeMillis()
        )

        viewModelScope.launch {
            uc.addBook(bookModel)
        }.invokeOnCompletion {
            onAdd(bookModel)
        }
    }
}