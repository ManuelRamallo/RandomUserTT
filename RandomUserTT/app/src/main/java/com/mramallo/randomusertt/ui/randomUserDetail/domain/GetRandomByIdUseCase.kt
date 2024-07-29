package com.mramallo.randomusertt.ui.randomUserDetail.domain

import com.mramallo.randomusertt.core.data.repositories.RandomUserTTRepository
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUser

class GetRandomByIdUseCase(
    private val randomUserTTRepository: RandomUserTTRepository
) {

    suspend fun invoke(id: String): RandomUser = randomUserTTRepository.getRandomUserById(id).toRandomUser()

}