package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUserItem(
    val gender: String,
    val email: String,
    val phone: String,
    val cell: String,
    val nat: String,
    val name: RandomUserName,
    val location: RandomUserLocation,
    val picture: RandomUserPicture
)
