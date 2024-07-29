package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUserItem(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
) {
    companion object {
        fun getMock(): RandomUserItem {
            return RandomUserItem(
                id = "id",
                email = "email",
                firstName = "firstName",
                lastName = "lastName",
                avatar = "avatar"
            )
        }
    }
}
