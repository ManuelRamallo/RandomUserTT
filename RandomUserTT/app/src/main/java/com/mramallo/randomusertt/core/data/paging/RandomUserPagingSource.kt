package com.mramallo.randomusertt.core.data.paging

import androidx.paging.LoadState
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mramallo.randomusertt.core.data.api.RandomUserTTApi
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUserItem
import okio.IOException
import javax.inject.Inject

class RandomUserPagingSource @Inject constructor(private val randomUserApi: RandomUserTTApi): PagingSource<Int, RandomUserItem>() {
    override fun getRefreshKey(state: PagingState<Int, RandomUserItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RandomUserItem> {

        return try {
            val page = params.key ?: 1
            val response = randomUserApi.getRandomUsers(page, 6)
            val randomUsers = response.body()?.data

            val prevKey = if (page > 0) page -1 else null
            val nextKey = if(response.body()?.data?.isNotEmpty() == true) page + 1 else null

            if(randomUsers.isNullOrEmpty()){
                LoadState.Error(throw Exception("No hay resultados disponibles"))
            }

            LoadResult.Page(
                data = randomUsers?.map { it.toRandomUserItem() } ?: emptyList(),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException){
            LoadResult.Error(exception)
        }

    }
}