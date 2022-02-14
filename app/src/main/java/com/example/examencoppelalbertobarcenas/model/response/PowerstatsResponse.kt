package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class PowerstatsResponse (
        @SerializedName("intelligence")        var intelligence: String,
        @SerializedName("strength")            var strength: String,
        @SerializedName("speed")               var speed: String,
        @SerializedName("durability")          var durability: String,
        @SerializedName("power")               var power: String,
        @SerializedName("combat")              var combat: String
    )
