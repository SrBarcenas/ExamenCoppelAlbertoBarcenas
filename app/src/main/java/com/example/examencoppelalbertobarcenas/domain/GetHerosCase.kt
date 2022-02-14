package com.cursokotlin.mvvmexample.domain

import com.example.examencoppelalbertobarcenas.network.HeroRepository

class GetHerosCase {

    private val repository = HeroRepository()
    suspend operator fun invoke(name: String) = repository.getHeros(name)
}