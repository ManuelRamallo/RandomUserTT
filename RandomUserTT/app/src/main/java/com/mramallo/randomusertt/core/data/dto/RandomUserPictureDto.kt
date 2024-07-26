package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserPictureDto(
    @SerializedName("large") val large: String?,
    @SerializedName("medium") val medium: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
)
