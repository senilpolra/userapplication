package com.example.userapplication.netwrok

import com.example.userapplication.RegisterActivity
import com.example.userapplication.models.LoginPassData
import com.example.userapplication.models.LoginResponse
import com.example.userapplication.models.RegisterPassData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("api/authaccount/login")
    fun login(@Body loginData: LoginPassData): Call<LoginResponse>

    @POST("api/authaccount/registration")
    fun register(@Body registerPassData: RegisterPassData): Call<LoginResponse>
}