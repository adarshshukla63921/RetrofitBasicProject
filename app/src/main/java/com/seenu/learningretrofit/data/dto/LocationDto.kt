package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDto(
    @field:Json(name = "city") val city : String,
    @field:Json(name = "country") val country : String,
)
