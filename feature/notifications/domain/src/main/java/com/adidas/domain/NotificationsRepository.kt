package com.adidas.domain

import com.adidas.domain.entities.Notification
import kotlinx.coroutines.flow.Flow

fun interface NotificationsRepository {
    fun getNotifications(): Flow<List<Notification>>
}
