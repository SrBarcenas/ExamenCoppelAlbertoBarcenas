package com.example.examencoppelalbertobarcenas.fragment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.mvvmexample.domain.GetHerosCase
import com.example.examencoppelalbertobarcenas.model.response.BaseResponse
import kotlinx.coroutines.launch

class SearchHeroViewModel () : ViewModel() {
    val heroModel = MutableLiveData<BaseResponse>()
    var getHerosCase = GetHerosCase()

    fun getHeros(name: String) {
        viewModelScope.launch {
            val result = getHerosCase.invoke(name)

            if(result != null){
                heroModel.postValue(result)
            }
        }
    }
}