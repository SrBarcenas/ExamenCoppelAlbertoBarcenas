package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class AppearanceResponse (
        @SerializedName("gender")           var gender: String,
        @SerializedName("race")             var race: String,
        @SerializedName("height")           var height: List<String>?,
        @SerializedName("weight")           var weight: List<String>?,
        @SerializedName("eye-color")        var eyeColor: String,
        @SerializedName("hair-color")       var hairColor: String
    )
