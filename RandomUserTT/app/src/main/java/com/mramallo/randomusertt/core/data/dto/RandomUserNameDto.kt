package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserNameDto(
    @SerializedName("title") val title: String?,
    @SerializedName("first") val first: String?,
    @SerializedName("last") val last: String?
)
