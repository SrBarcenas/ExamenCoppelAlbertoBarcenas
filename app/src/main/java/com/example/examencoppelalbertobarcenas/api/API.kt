package com.example.examencoppelalbertobarcenas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    val BASE_URL = "https://superheroapi.com/api/2321140144771513/"
    private var retrofit: Retrofit? = null

    fun getApi(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}