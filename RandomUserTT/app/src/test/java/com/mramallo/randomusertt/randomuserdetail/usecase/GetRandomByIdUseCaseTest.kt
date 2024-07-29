package com.mramallo.randomusertt.randomuserdetail.usecase

import com.mramallo.randomusertt.core.data.repositories.RandomUserTTRepository
import com.mramallo.randomusertt.randomuserdetail.mapper.sampleRandomUserDto
import com.mramallo.randomusertt.ui.randomUserDetail.domain.GetRandomByIdUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetRandomByIdUseCaseTest {

    @RelaxedMockK
    lateinit var randomUserTTRepository: RandomUserTTRepository

    lateinit var getRandomUserByIdUseCase: GetRandomByIdUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomUserByIdUseCase = GetRandomByIdUseCase(randomUserTTRepository)
    }

    @Test
    fun `getRandomByIdUseCase when success should return Result with Banner`() = runBlocking {
        coEvery {
            randomUserTTRepository.getRandomUserById("1")
        } answers {
            sampleRandomUserDto()
        }
        runTest {
            val result = randomUserTTRepository.getRandomUserById("1")
            assert(result.data?.id == "1")
        }
    }



}