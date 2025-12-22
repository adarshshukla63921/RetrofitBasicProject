package com.seenu.learningretrofit.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seenu.learningretrofit.domain.repository.UserRepository
import com.seenu.learningretrofit.domain.uiState.UserState
import com.seenu.learningretrofit.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel
    @Inject constructor(
        private val repository: UserRepository
    )
    : ViewModel() {
        val _state = mutableStateOf(UserState(user=null))

    init {
        getUserProfile()
    }

     fun getUserProfile(){
        repository.getUserProfile().onEach {
            result->
            when(result) {
                is Resource.IsLoading -> {
                    _state.value = UserState(isLoading = true, user=null)
                }
                is Resource.Success -> {
                    _state.value = UserState(user = result.data)
                }
                is Resource.Error -> {
                    _state.value = UserState(error = result.message?:"Unknown Error occurred", user=null)
                }
            }
        }.launchIn(viewModelScope)
    }
}