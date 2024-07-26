package com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper

import com.mramallo.randomusertt.core.data.dto.RandomUserItemDto
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem

fun RandomUserItemDto.toRandomUserItem() = RandomUserItem(
    id = id ?: "",
    email = email ?: "",
    firstName = firstName ?: "",
    lastName = lastName ?: "",
    avatar = avatar ?: ""
)