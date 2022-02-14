package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class HeroResponse (
        @SerializedName("id")           var id: String,
        @SerializedName("name")         var name: String,
        @SerializedName("image")        var image: ImageResponse
    )
