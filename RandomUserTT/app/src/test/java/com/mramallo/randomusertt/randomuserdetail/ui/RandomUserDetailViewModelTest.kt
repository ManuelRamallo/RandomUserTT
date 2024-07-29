package com.mramallo.randomusertt.randomuserdetail.ui

import com.mramallo.randomusertt.ui.randomUserDetail.RandomUserDetailViewModel
import com.mramallo.randomusertt.ui.randomUserDetail.domain.GetRandomByIdUseCase
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test


class RandomUserDetailViewModelTest {

    @RelaxedMockK
    private lateinit var getRandomUserByIdUseCase: GetRandomByIdUseCase

    private lateinit var randomUserDetailViewModel: RandomUserDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        randomUserDetailViewModel = RandomUserDetailViewModel(getRandomUserByIdUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getRandomById() using RandomUserDetailViewModel()`() = runTest {
        val randomUser = RandomUser.getMock()
        coEvery { getRandomUserByIdUseCase.invoke("1") } returns randomUser

        randomUserDetailViewModel.getRandomById("1")
        assertEquals(randomUserDetailViewModel.stateRandomItem?.user, randomUser)
    }

}