package com.mramallo.randomusertt.ui.randomUser.domain.entity

import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem

data class RandomUserList(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<RandomUserItem>
)
