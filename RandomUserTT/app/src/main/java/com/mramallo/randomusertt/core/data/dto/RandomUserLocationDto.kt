package com.mramallo.randomusertt.core.data.dto

import com.google.gson.annotations.SerializedName

data class RandomUserLocationDto(
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("postCode") val postCode: String?,
    @SerializedName("street") val street: LocationStreetDto?,
    @SerializedName("coordinates") val coordinates: LocationCoordinatesDto?,
    @SerializedName("timezone") val timezone: LocationTimezoneDto?,
)


/*DTO's children are added to the parent class*/
data class LocationStreetDto(
    @SerializedName("number") val number: Int?,
    @SerializedName("name") val name: String?
)

data class LocationCoordinatesDto(
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?
)

data class LocationTimezoneDto(
    @SerializedName("offset") val offset: String?,
    @SerializedName("description") val description: String?
)