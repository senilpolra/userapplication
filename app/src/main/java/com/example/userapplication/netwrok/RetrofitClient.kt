package com.example.userapplication.netwrok

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URT = "http://www.quickpickdeal.com"


    val instance: ApiInterface by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()

        retrofit.create(ApiInterface::class.java)
    }

}