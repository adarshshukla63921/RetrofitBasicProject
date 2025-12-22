package com.seenu.learningretrofit.data.mappers

import com.seenu.learningretrofit.data.dto.StatisticsDto
import com.seenu.learningretrofit.domain.model.Statistics

fun StatisticsDto.toDomain() : Statistics{
    return Statistics(
        followers = this.followers,
        following = this.following,
        activity = this.activity.toDomain()
    )
}