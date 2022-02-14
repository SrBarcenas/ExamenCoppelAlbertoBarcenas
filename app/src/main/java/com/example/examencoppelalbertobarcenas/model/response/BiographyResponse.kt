package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class BiographyResponse (
            @SerializedName("full-name")                var fullName: String,
            @SerializedName("alter-egos")               var alterEgos: String,
            @SerializedName("place-of-birth")           var placeBirth: String,
            @SerializedName("first-appearance")         var firstAppearance: String,
            @SerializedName("publisher")                var publisher: String,
            @SerializedName("alignment")                var alignment: String
        )
