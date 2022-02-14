package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class DetailsResponse (
        @SerializedName("response")         var response: String,
        @SerializedName("id")               var id: String,
        @SerializedName("name")             var name: String,
        @SerializedName("image")            var image: ImageResponse,
        @SerializedName("powerstats")       var powerstats: PowerstatsResponse?,
        @SerializedName("biography")        var biography: BiographyResponse?,
        @SerializedName("appearance")       var appearance: AppearanceResponse?,
        @SerializedName("work")             var work: WorkResponse?,
        @SerializedName("connections")      var connections: ConnectionsResponse?
    )
