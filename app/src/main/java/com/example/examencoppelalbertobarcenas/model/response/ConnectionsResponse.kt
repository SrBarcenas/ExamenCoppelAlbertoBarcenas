package com.example.examencoppelalbertobarcenas.model.response

import com.google.gson.annotations.SerializedName

data class ConnectionsResponse (
        @SerializedName("group-affiliation")            var groupAffiliation: String,
        @SerializedName("relatives")                    var relatives: String
    )
