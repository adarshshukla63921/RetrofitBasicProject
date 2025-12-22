package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.ActivityDto
import com.seenu.learningretrofit.domain.model.Activity

fun ActivityDto.toDomain() : Activity {
    return Activity(
        shots = this.shots,
        collections = this.collections
    )
}