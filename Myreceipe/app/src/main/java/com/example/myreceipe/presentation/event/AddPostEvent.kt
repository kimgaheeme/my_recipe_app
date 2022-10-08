package com.example.myreceipe.presentation.event

import androidx.compose.ui.focus.FocusState

sealed class AddPostEvent {
    data class EnteredTitle(val value: String): AddPostEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddPostEvent()
    data class EnteredContent(val value: String): AddPostEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddPostEvent()
    data class EnteredLink(val value: String): AddPostEvent()
    data class ChangeLinkFocus(val focusState: FocusState): AddPostEvent()
    data class EnteredIngredient(val value: String): AddPostEvent()
    data class ChangeIngredientFocus(val focusState: FocusState): AddPostEvent()
    object SavePost: AddPostEvent()
}