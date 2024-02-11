package com.adidas.data

import com.adidas.domain.NotificationsRepository
import com.adidas.domain.entities.Notification
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NotificationsRepositoryImpl @Inject constructor() : NotificationsRepository {
    override fun getNotifications(): Flow<List<Notification>> {
        return flowOf(
            listOf(
                Notification.mock(1),
                Notification.mock(2),
            )
        )
    }
}
