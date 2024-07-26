package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserItemDto(
    @SerializedName("gender") val gender: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("cell") val cell: String?,
    @SerializedName("nat") val nat: String?,
    @SerializedName("name") val name: RandomUserNameDto?,
    @SerializedName("location") val location: RandomUserLocationDto?,
    @SerializedName("picture") val picture: RandomUserPictureDto?
)
