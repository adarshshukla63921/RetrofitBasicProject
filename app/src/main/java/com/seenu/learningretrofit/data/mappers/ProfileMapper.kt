package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.ProfileDto
import com.seenu.learningretrofit.domain.model.Profile

fun ProfileDto.toDomain() : Profile{
    return Profile(
        platform = this.platform,
        url = this.url
    )
}