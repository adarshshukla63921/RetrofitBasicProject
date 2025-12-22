package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.LocationDto
import com.seenu.learningretrofit.domain.model.Location

fun LocationDto.toDomain() : Location{
    return Location(
        city = this.city,
        country = this.country
    )
}