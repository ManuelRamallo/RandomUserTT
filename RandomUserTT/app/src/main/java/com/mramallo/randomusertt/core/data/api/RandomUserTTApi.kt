package com.mramallo.randomusertt.core.data.api

import com.mramallo.randomusertt.core.data.dto.RandomUserListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserTTApi {

    @GET("/api/users")
    suspend fun getRandomUsers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<RandomUserListDto>


}