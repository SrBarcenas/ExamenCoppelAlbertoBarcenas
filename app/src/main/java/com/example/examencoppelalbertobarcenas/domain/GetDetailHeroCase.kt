package com.cursokotlin.mvvmexample.domain

import com.example.examencoppelalbertobarcenas.network.DetailHeroRepository

class GetDetailHeroCase {

    private val repository = DetailHeroRepository()
    suspend operator fun invoke(id: String) = repository.getDetailHero(id)
}