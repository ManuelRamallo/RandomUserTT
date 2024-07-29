package com.mramallo.randomusertt.di

import com.mramallo.randomusertt.core.data.repositories.RandomUserTTRepository
import com.mramallo.randomusertt.ui.randomUserDetail.domain.GetRandomByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppUseCasesModule {

    @Provides
    @Singleton
    fun providesGetRandomByIdUseCase(
        randomUserTTRepository: RandomUserTTRepository
    ) = GetRandomByIdUseCase(randomUserTTRepository)

}