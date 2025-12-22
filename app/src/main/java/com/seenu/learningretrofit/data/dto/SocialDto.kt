package com.seenu.learningretrofit.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class SocialDto(
    @field:Json(name = "website") val website : String,
    @field:Json(name = "profiles") val profiles : List<ProfileDto>
)
