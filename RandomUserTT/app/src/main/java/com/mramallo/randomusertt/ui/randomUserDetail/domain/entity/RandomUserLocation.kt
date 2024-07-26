package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUserLocation(
    val city: String,
    val state: String,
    val country: String,
    val postCode: String,
    val street: LocationStreet,
    val coordinates: LocationCoordinates,
    val timezone: LocationTimezone
){
    companion object {
        fun getMock(): RandomUserLocation {
            return RandomUserLocation(
                city = "city",
                state = "state",
                country = "country",
                postCode = "postCode",
                street = LocationStreet(1, "name"),
                coordinates = LocationCoordinates("latitude", "longitude"),
                timezone = LocationTimezone("offset", "description")
            )
        }
    }
}


/*Entities children are added to the parent class*/
data class LocationStreet(
    val number: Int,
    val name: String
)

data class LocationCoordinates(
    val latitude: String,
    val longitude: String
)

data class LocationTimezone(
    val offset: String,
    val description: String
)