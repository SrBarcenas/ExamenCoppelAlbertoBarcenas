package com.example.examencoppelalbertobarcenas.model

import com.example.examencoppelalbertobarcenas.model.response.BaseResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroProvider @Inject constructor() {
    var heros: BaseResponse? = null
}