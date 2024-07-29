package com.mramallo.randomusertt.core.data.api

import com.mramallo.randomusertt.core.data.dto.RandomUserDto
import com.mramallo.randomusertt.core.data.dto.RandomUserListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RandomUserTTApi {

    @GET("/api/users")
    suspend fun getRandomUsers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): RandomUserListDto

    @GET("/api/users/{id}")
    suspend fun getRandomUserById(
        @Path("id") idUser: String,
    ): RandomUserDto


}