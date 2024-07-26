package com.mramallo.randomusertt.ui.randomUser.domain.entity

data class RandomUserListInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
){
    companion object {
        fun getMock(): RandomUserListInfo {
            return RandomUserListInfo(
                seed = "",
                results = 0,
                page = 0,
                version = ""
            )
        }
    }
}
