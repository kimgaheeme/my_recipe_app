package com.example.myreceipe.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreceipe.domain.model.InvalidPostException
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository
import com.example.myreceipe.domain.usecase.post.IngredientUseCase
import com.example.myreceipe.domain.usecase.post.PostUseCase
import com.example.myreceipe.presentation.event.AddPostEvent
import com.example.myreceipe.presentation.state.PostTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    private val ingredientUseCase: IngredientUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _title = mutableStateOf(PostTextFieldState(
        hint = "title"
    ))
    val title: State<PostTextFieldState> = _title

    private val _content = mutableStateOf(PostTextFieldState(
        hint = "content"
    ))
    val content:State<PostTextFieldState> = _content

    private val _ingredient = mutableStateOf(PostTextFieldState(
        hint = "ingredient"
    ))
    val ingredient :State<PostTextFieldState> = _ingredient

    private val _link = mutableStateOf(PostTextFieldState(
        hint = "link"
    ))
    val link :State<PostTextFieldState> = _link

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPostId: Int? = null

    init {
        savedStateHandle.get<Int>("postId")?.let { postId ->
            if(postId != -1) {
                viewModelScope.launch {
                    postUseCase.getPostDetail(postId)?.also { post ->
                        currentPostId = post.id
                        _title.value = title.value.copy(
                            text = post.title,
                            isHintVisible = false
                        )
                        _content.value = content.value.copy(
                            text = post.content,
                            isHintVisible = false
                        )
                        _link.value = link.value.copy(
                            text = post.link,
                            isHintVisible = false
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddPostEvent) {
        when(event) {
            is AddPostEvent.EnteredTitle -> {
                _title.value = title.value.copy(
                    text = event.value
                )
            }
            is AddPostEvent.ChangeTitleFocus -> {
                _title.value = title.value.copy(
                    isHintVisible = !event.focusState.isFocused && title.value.text.isBlank()
                )
            }
            is AddPostEvent.EnteredContent -> {
                _content.value = content.value.copy(
                    text = event.value
                )
            }
            is AddPostEvent.ChangeContentFocus -> {
                _content.value = content.value.copy(
                    isHintVisible = !event.focusState.isFocused && content.value.text.isBlank()
                )
            }
            is AddPostEvent.EnteredLink -> {
                _link.value = link.value.copy(
                    text = event.value
                )
            }
            is AddPostEvent.ChangeLinkFocus -> {
                _link.value = link.value.copy(
                    isHintVisible = !event.focusState.isFocused && link.value.text.isBlank()
                )
            }
            is AddPostEvent.EnteredIngredient -> {
                _ingredient.value = ingredient.value.copy(
                    text = event.value
                )
            }
            is AddPostEvent.ChangeIngredientFocus -> {
                _ingredient.value = ingredient.value.copy(
                    isHintVisible = !event.focusState.isFocused && ingredient.value.text.isBlank()
                )
            }
            is AddPostEvent.SavePost -> {
                viewModelScope.launch {
                    try {
                        postUseCase.addPost(
                            Post(
                                title = title.value.text,
                                content = content.value.text,
                                link = link.value.text,
                                id = currentPostId
                            )
                        )

                        ingredientUseCase.addIngredient(
                            
                        )


                        _eventFlow.emit(UiEvent.SavePost)
                    } catch(e: InvalidPostException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
            }
        }

    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SavePost: UiEvent()
    }

}