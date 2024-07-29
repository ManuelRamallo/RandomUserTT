package com.mramallo.randomusertt.core.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mramallo.randomusertt.core.data.api.RandomUserTTApi
import com.mramallo.randomusertt.core.data.dto.RandomUserDto
import com.mramallo.randomusertt.core.data.paging.RandomUserPagingSource
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class RandomUserTTRepository @Inject constructor(
    val randomUserTTApi: RandomUserTTApi
) {

    companion object {
        const val MAX_ITEMS = 6
        const val PREFETCH_ITEMS = 3
    }

    /** Get all random users*/
    fun getRandomUsers(): Flow<PagingData<RandomUserItem>> {
        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                RandomUserPagingSource(randomUserApi = randomUserTTApi)
            }).flow
    }

    /** Get random user by id*/
    suspend fun getRandomUserById(id: String): RandomUserDto = randomUserTTApi.getRandomUserById(id)

}