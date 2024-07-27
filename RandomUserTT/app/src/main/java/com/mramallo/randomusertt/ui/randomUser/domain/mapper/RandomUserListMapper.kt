package com.mramallo.randomusertt.ui.randomUser.domain.mapper

import com.mramallo.randomusertt.core.data.dto.RandomUserListDto
import com.mramallo.randomusertt.ui.randomUser.domain.entity.RandomUserList
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUserItem

fun RandomUserListDto.toRandomUserList() = RandomUserList(
    page = page ?: 0,
    perPage = perPage ?: 0,
    total = total ?: 0,
    totalPages = totalPages ?: 0,
    data = data?.map { it.toRandomUserItem() } ?: emptyList()
)