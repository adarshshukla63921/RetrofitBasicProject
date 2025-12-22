package com.seenu.learningretrofit.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ProfileDto(
    @field:Json(name = "platform") val platform: String,
    @field:Json(name = "url") val url : String
)
