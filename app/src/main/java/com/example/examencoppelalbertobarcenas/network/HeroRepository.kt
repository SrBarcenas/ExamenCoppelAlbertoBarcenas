package com.example.examencoppelalbertobarcenas.network

import com.example.examencoppelalbertobarcenas.api.APIService.HeroService
import com.example.examencoppelalbertobarcenas.model.response.BaseResponse
import com.example.examencoppelalbertobarcenas.model.HeroProvider

class HeroRepository {

    private val api = HeroService()
    private val heroProvider = HeroProvider()

    suspend fun getHeros(name: String): BaseResponse {
        val response = api.getHeros(name)
        heroProvider.heros = response
        return response
    }
}