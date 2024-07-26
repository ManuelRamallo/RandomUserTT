package com.mramallo.randomusertt.ui.randomUserDetail.domain.entity

data class RandomUserPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
) {
    companion object {
        fun getMock(): RandomUserPicture{
            return RandomUserPicture(
                large = "large",
                medium = "medium",
                thumbnail = "thumbnail"
            )
        }
    }
}
