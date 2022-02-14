package com.example.examencoppelalbertobarcenas.network

import com.example.examencoppelalbertobarcenas.model.response.BaseResponse
import com.example.examencoppelalbertobarcenas.model.response.DetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroClient {

    @GET("search/{search}")
    suspend fun getHeros(@Path("search") name: String): Response<BaseResponse>

    @GET("{id}")
    suspend fun getDetailsHero(@Path("id") name: String): Response<DetailsResponse>
}