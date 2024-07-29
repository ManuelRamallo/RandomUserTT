package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserDto(
    @SerializedName("data") val data: RandomUserItemDto?
)
