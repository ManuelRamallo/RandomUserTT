package com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper

import com.mramallo.randomusertt.core.data.dto.LocationCoordinatesDto
import com.mramallo.randomusertt.core.data.dto.LocationStreetDto
import com.mramallo.randomusertt.core.data.dto.LocationTimezoneDto
import com.mramallo.randomusertt.core.data.dto.RandomUserItemDto
import com.mramallo.randomusertt.core.data.dto.RandomUserLocationDto
import com.mramallo.randomusertt.core.data.dto.RandomUserNameDto
import com.mramallo.randomusertt.core.data.dto.RandomUserPictureDto
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.LocationCoordinates
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.LocationStreet
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.LocationTimezone
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserLocation
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserName
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserPicture

fun RandomUserItemDto.toRandomUserItem() = RandomUserItem(
    gender = gender ?: "",
    email = email ?: "",
    phone = phone ?: "",
    cell = cell ?: "",
    nat = nat ?: "",
    name = name?.toRandomUserName() ?: RandomUserName.getMock(),
    location = location?.toRandomUserLocation() ?: RandomUserLocation.getMock(),
    picture = picture?.toRandomUserPicture() ?: RandomUserPicture.getMock()
)

fun RandomUserNameDto.toRandomUserName() = RandomUserName(
    title = title ?: "",
    first = first ?: "",
    last = last ?: ""
)

fun RandomUserPictureDto.toRandomUserPicture() = RandomUserPicture(
    large = large ?: "",
    medium = medium ?: "",
    thumbnail = thumbnail ?: ""
)

fun RandomUserLocationDto.toRandomUserLocation() = RandomUserLocation(
    city = city ?: "",
    state = state ?: "",
    country = country ?: "",
    postCode = postCode ?: "",
    street = street?.toLocationStreet() ?: LocationStreet(0, ""),
    timezone = timezone?.toLocationTimezone() ?: LocationTimezone("", ""),
    coordinates = coordinates?.toLocationCoordinates() ?: LocationCoordinates("", "")
)

fun LocationStreetDto.toLocationStreet() = LocationStreet(
    number = number ?: 0,
    name = name ?: ""
)

fun LocationTimezoneDto.toLocationTimezone() = LocationTimezone(
    offset = offset ?: "",
    description = description ?: ""
)

fun LocationCoordinatesDto.toLocationCoordinates() = LocationCoordinates(
    latitude = latitude ?: "",
    longitude = longitude ?: ""
)

