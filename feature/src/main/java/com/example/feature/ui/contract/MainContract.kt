package com.example.feature.ui.contract


import com.example.base.UiEffect
import com.example.base.UiEvent
import com.example.base.UiState
import com.example.feature.model.BookUiModel

/**
 * Contract of Main Screen
 */
class MainContract {

    sealed class Event : UiEvent {
        object OnFetchBooks : Event()
        data class OnBookItemClicked(val book : BookUiModel) : Event()
    }

    data class State(
        val bookState: BooksState,
        val selectedBook: BookUiModel? = null
    ) : UiState

    sealed class BooksState {
        object Idle : BooksState()
        object Loading : BooksState()
        data class Success(val bookList : List<BookUiModel>) : BooksState()
    }

    sealed class Effect : UiEffect {

        data class ShowError(val message : String?) : Effect()

    }

}