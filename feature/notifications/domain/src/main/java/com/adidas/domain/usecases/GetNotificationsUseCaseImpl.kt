package com.adidas.domain.usecases

import com.adidas.domain.NotificationsRepository
import com.adidas.domain.entities.Notification
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetNotificationsUseCaseImpl @Inject constructor(private val notificationsRepository: NotificationsRepository) : GetNotificationsUseCase {
    override fun invoke(): Flow<List<Notification>> {
        return notificationsRepository.getNotifications()
    }
}
