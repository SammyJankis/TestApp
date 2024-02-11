package com.adidas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adidas.domain.usecases.GetNotificationsUseCase
import com.adidas.entities.NotificationUiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class NotificationsViewModel @Inject constructor(getNotificationsUseCase: GetNotificationsUseCase) : ViewModel() {

    val notificationState: StateFlow<NotificationState> = getNotificationsUseCase.invoke()
        .map { notifications ->
            val notificationsUiEntities = notifications.map {
                NotificationUiEntity(it.title, it.message)
            }
            NotificationState.Success(notificationsUiEntities)
        }
        .catch {
            NotificationState.Error(it.message ?: "An error occurred")
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = NotificationState.Loading
        )
}

sealed class NotificationState {
    data object Loading : NotificationState()
    data class Success(val notifications: List<NotificationUiEntity>) : NotificationState()
    data class Error(val message: String) : NotificationState()
}

