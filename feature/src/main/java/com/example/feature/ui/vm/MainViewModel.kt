package com.example.feature.ui.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.common.Mapper
import com.example.common.Resource
import com.example.domain.entity.BookEntity
import com.example.domain.usecase.GetBooksUseCase
import com.example.feature.model.BookUiModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import com.example.feature.ui.contract.MainContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getBooksUseCase: GetBooksUseCase,
    private val bookMapper : Mapper<BookEntity, BookUiModel>
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>(){

    override fun createInitialState(): MainContract.State {
        return MainContract.State(
            bookState = MainContract.BooksState.Idle,
            selectedBook = null
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.OnFetchBooks -> {
                fetchBooks()
            }
            is MainContract.Event.OnBookItemClicked -> {
                val item = event.book
                setSelectedBook(book = item)
            }
        }
    }

    /**
     * Fetch books
     */
    private fun fetchBooks() {
        viewModelScope.launch {
            getBooksUseCase.execute(null)
                    .onStart {
                        emit(Resource.Loading)
                    }
                    .collect {
                        when (it) {
                            is Resource.Loading -> {
                                // Set State
                                setState { copy(bookState = MainContract.BooksState.Loading)
                                }
                            }
                            is Resource.Empty -> {
                                // Set State
                                setState { copy(bookState = MainContract.BooksState.Idle) }
                            }
                            is Resource.Success -> {
                                // Set State
                                val bookList = bookMapper.fromList(it.data)
                                setState {
                                    copy(
                                        bookState = MainContract.BooksState.Success(
                                            bookList = bookList
                                        )
                                    )
                                }
                            }
                            is Resource.Error -> {
                                // Set Effect
                                setState { copy(bookState = MainContract.BooksState.Idle)}
                                setEffect { MainContract.Effect.ShowError(message = it.exception.message) }
                            }
                        }
                    }

        }
    }

    /**
     * Set selected book item
     */
    private fun setSelectedBook(book : BookUiModel?) {
        // Set State
        setState { copy(selectedBook = book) }
    }

    init {
        setEvent(MainContract.Event.OnFetchBooks)

    }
}