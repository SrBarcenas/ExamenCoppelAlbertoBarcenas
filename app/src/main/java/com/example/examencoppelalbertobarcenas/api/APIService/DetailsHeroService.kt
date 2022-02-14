package com.example.examencoppelalbertobarcenas.api.APIService

import com.example.examencoppelalbertobarcenas.api.API
import com.example.examencoppelalbertobarcenas.model.response.DetailsResponse
import com.example.examencoppelalbertobarcenas.network.HeroClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsHeroService(){

    private val retrofit = API.getApi()

    suspend fun getDetailsHero(id: String): DetailsResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit?.create(HeroClient::class.java)?.getDetailsHero(id)

            (response!!.body() ?: null) as DetailsResponse
        }
    }
}