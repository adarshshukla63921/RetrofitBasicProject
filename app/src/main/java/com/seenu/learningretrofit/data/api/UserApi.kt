package com.seenu.learningretrofit.data.api

import com.seenu.learningretrofit.data.dto.UserResponse
import retrofit2.http.GET



interface UserApi {
    @GET("android-assesment/profile/refs/heads/main/data.json")
    suspend fun userProfile() : UserResponse
}