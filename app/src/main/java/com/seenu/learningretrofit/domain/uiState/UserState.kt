package com.seenu.learningretrofit.domain.uiState

import com.seenu.learningretrofit.domain.model.User

data class UserState(
    val isLoading : Boolean = false,
    val user : User?,
    val error : String = ""
)
