package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.SocialDto
import com.seenu.learningretrofit.domain.model.Social

fun SocialDto.toDomain() : Social{
    return Social(
        website = this.website,
        profiles = this.profiles.map{it.toDomain()}
    )
}