package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserDto(
    @field:Json(name = "username") val username : String,
    @field:Json(name = "name") val name : String,
    @field:Json(name = "location") val location : LocationDto,
    @field:Json(name = "avatar") val avatar : String,
    @field:Json(name = "social") val social : SocialDto,
    @field:Json(name = "statistics") val statistics : StatisticsDto
)
