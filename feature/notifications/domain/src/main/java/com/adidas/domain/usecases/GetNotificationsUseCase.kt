package com.adidas.domain.usecases

import com.adidas.domain.entities.Notification
import kotlinx.coroutines.flow.Flow

fun interface GetNotificationsUseCase {
    fun invoke(): Flow<List<Notification>>
}
