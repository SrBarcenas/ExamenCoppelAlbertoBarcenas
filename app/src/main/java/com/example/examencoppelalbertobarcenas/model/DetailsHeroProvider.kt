package com.example.examencoppelalbertobarcenas.model

import com.example.examencoppelalbertobarcenas.model.response.DetailsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsHeroProvider @Inject constructor() {
    var heros: DetailsResponse? = null
}