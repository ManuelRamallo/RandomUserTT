package com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper

import com.mramallo.randomusertt.core.data.dto.RandomUserDto
import com.mramallo.randomusertt.core.data.dto.RandomUserItemDto
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem

fun RandomUserDto.toRandomUser() = RandomUser(
    data = data?.toRandomUserItem() ?: RandomUserItem.getMock()
)

fun RandomUserItemDto.toRandomUserItem() = RandomUserItem(
    id = id ?: "",
    email = email ?: "",
    firstName = firstName ?: "",
    lastName = lastName ?: "",
    avatar = avatar ?: ""
)

