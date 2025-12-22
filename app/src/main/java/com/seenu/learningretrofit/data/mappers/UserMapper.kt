package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.UserDto
import com.seenu.learningretrofit.domain.model.User

fun UserDto.toDomain() : User{
    return User(
        username = this.username,
        name = this.name,
        location = this.location.toDomain(),
        avatar = this.avatar,
        social = this.social.toDomain(),
        statistics = this.statistics.toDomain()
    )
}