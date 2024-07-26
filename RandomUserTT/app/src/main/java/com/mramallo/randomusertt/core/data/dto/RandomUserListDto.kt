package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserListDto(
    @SerializedName("results") val results: List<RandomUserItemDto>?,
    @SerializedName("info") val info: RandomUserListInfoDto?
)
