package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUser(
    val data: RandomUserItem
) {
    companion object {
        fun getMock(): RandomUser {
            return RandomUser(
                data = RandomUserItem.getMock()
            )
        }
    }
}
