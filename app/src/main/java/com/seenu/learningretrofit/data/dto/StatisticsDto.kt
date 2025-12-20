package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatisticsDto(
    @field:Json(name="followers") val followers : Int,
    @field:Json(name="following") val following : Int,
    @field:Json(name="activity") val activity: ActivityDto
)
