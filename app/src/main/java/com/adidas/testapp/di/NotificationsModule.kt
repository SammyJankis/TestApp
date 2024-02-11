package com.adidas.testapp.di

import com.adidas.data.NotificationsRepositoryImpl
import com.adidas.domain.NotificationsRepository
import com.adidas.domain.usecases.GetNotificationsUseCase
import com.adidas.domain.usecases.GetNotificationsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NotificationsModule {

    @Binds
    fun bindGetNotificationsUseCase(getNotificationsUseCaseImpl: GetNotificationsUseCaseImpl): GetNotificationsUseCase

    @Binds
    fun bindNotificationsRepository(notificationsRepositoryImpl: NotificationsRepositoryImpl): NotificationsRepository
}
