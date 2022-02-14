package com.example.examencoppelalbertobarcenas.api.APIService

import com.example.examencoppelalbertobarcenas.api.API
import com.example.examencoppelalbertobarcenas.model.response.BaseResponse
import com.example.examencoppelalbertobarcenas.network.HeroClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroService(){

    private val retrofit = API.getApi()

    suspend fun getHeros(name: String): BaseResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit?.create(HeroClient::class.java)?.getHeros(name)

            (response!!.body() ?: null) as BaseResponse
        }
    }
}