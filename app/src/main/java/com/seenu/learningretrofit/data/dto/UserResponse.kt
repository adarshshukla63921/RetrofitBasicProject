package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @field:Json(name="user") val user : UserDto
)
