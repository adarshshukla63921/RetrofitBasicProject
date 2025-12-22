package com.seenu.learningretrofit.domain.model

data class User(
    val username : String,
    val name : String,
    val location: Location,
    val avatar : String,
    val social : Social,
    val statistics: Statistics
)
