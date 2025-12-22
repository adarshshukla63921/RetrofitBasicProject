package com.seenu.learningretrofit.domain.repository

import com.seenu.learningretrofit.domain.model.User
import com.seenu.learningretrofit.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserProfile() : Flow<Resource<User>>
}