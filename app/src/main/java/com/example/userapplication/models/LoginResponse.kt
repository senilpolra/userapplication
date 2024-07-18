package com.example.userapplication.models

data class LoginResponse(
    val `$id`: String,
    val code: Int,
    val `data`: Data,
    val message: String
)