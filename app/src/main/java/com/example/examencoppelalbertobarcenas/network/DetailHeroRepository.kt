package com.example.examencoppelalbertobarcenas.network

import com.example.examencoppelalbertobarcenas.api.APIService.DetailsHeroService
import com.example.examencoppelalbertobarcenas.model.DetailsHeroProvider
import com.example.examencoppelalbertobarcenas.model.response.DetailsResponse

class DetailHeroRepository {

    private val api = DetailsHeroService()
    private val heroProvider = DetailsHeroProvider()

    suspend fun getDetailHero(id: String): DetailsResponse {
        val response = api.getDetailsHero(id)
        heroProvider.heros = response
        return response
    }
}