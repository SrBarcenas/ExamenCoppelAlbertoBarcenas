package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse (
        @SerializedName("response")         var status: String,
        @SerializedName("results-for")      var resultsFor: String,
        @SerializedName("results")          var results: List<HeroResponse>?
    )
