package com.mramallo.randomusertt.ui.randomUser.domain.mapper

import com.mramallo.randomusertt.core.data.dto.RandomUserListDto
import com.mramallo.randomusertt.core.data.dto.RandomUserListInfoDto
import com.mramallo.randomusertt.ui.randomUser.domain.entity.RandomUserList
import com.mramallo.randomusertt.ui.randomUser.domain.entity.RandomUserListInfo
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUserItem

fun RandomUserListDto.toRandomUserList() = RandomUserList(
    results = results?.map { it.toRandomUserItem() } ?: emptyList(),
    info = info?.toRandomUserListInfo() ?: RandomUserListInfo.getMock()
)

fun RandomUserListInfoDto.toRandomUserListInfo() = RandomUserListInfo(
    seed = seed ?: "",
    results = results ?: 1,
    page = page ?: 1,
    version = version ?: ""
)