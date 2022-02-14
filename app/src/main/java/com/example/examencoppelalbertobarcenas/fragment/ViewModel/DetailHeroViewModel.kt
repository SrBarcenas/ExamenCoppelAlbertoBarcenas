package com.example.examencoppelalbertobarcenas.fragment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.mvvmexample.domain.GetDetailHeroCase
import com.example.examencoppelalbertobarcenas.model.response.DetailsResponse
import kotlinx.coroutines.launch

class DetailHeroViewModel : ViewModel() {

    val detailHeroModel = MutableLiveData<DetailsResponse>()
    var getDetailHeroCase = GetDetailHeroCase()

    fun getDetails(id: String) {
        viewModelScope.launch {
            val result = getDetailHeroCase.invoke(id)

            if(result != null){
                detailHeroModel.postValue(result)
            }
        }
    }
}