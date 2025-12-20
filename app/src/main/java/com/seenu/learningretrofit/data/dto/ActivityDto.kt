package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActivityDto (
    @field:Json(name = "shots") val shots : Int = 0,
    @field:Json(name="collections") val collections : Int = 0
)
