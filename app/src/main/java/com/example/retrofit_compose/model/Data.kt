package com.example.retrofit_compose.model

import retrofit2.http.Body

data class Data(
    val body: String,
    val id: String,
    val title: String,
    val userId: Int
)
