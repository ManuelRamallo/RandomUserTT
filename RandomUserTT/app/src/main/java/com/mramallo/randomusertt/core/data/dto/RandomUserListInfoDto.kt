package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserListInfoDto(
    @SerializedName("seed") val seed: String?,
    @SerializedName("results") val results: Int?,
    @SerializedName("page") val page: Int?,
    @SerializedName("version") val version: String?,
)
