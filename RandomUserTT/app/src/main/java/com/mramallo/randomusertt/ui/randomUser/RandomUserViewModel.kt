package com.mramallo.randomusertt.ui.randomUser

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.mramallo.randomusertt.core.data.repositories.RandomUserTTRepository
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(randomUserTTRepository: RandomUserTTRepository): ViewModel(){

    val randomUsers: Flow<PagingData<RandomUserItem>> = randomUserTTRepository.getRandomUsers()

}