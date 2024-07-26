package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUserName(
    val title: String,
    val first: String,
    val last: String
) {
    companion object {
        fun getMock(): RandomUserName {
            return RandomUserName(
                title = "title",
                first = "first",
                last = "last"
            )
        }
    }
}
