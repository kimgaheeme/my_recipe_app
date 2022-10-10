package com.example.myreceipe.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.InvalidPostException
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository
import com.example.myreceipe.domain.usecase.post.IngredientUseCase
import com.example.myreceipe.domain.usecase.post.PostUseCase
import com.example.myreceipe.presentation.event.AddPostEvent
import com.example.myreceipe.presentation.state.DetailState
import com.example.myreceipe.presentation.state.PostTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    private val ingredientUseCase: IngredientUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var title = savedStateHandle.get<String>("title")
    private var _post = mutableStateOf(DetailState())
    val post: State<DetailState> = _post

    private val _ingredient = mutableStateOf(listOf<IngredientUse>())
    val ingredient: State<List<IngredientUse>> = _ingredient

    init {
        getDetail()
        getIngredient()
    }

    fun getDetail() {
        postUseCase.getPostDetail(title!!).onEach {
            _post.value = DetailState(title?: "",it?.content?: "",it?.link?: "")
        }.launchIn(viewModelScope)
    }

    fun getIngredient() {
        ingredientUseCase.getIngredientUseUseCase(title!!).onEach {
            _ingredient.value = it
        }.launchIn(viewModelScope)
    }
}