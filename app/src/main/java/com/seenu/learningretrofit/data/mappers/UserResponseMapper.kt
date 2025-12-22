package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.UserResponse
import com.seenu.learningretrofit.domain.model.User

fun UserResponse.toDomain() : User{
    return user.toDomain()
}