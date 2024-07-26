package com.mramallo.randomusertt.ui.randomUser.domain.entity

import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem

data class RandomUserList(
    val results: List<RandomUserItem>,
    val info: RandomUserListInfo
)
