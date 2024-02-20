package com.adidas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.adidas.entities.NotificationUiEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : Fragment() {
    private val viewModel: NotificationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val state = viewModel.notificationState.collectAsStateWithLifecycle()
                when (val result = state.value) {
                    is NotificationState.Loading -> {
                        // Show loading state
                    }

                    is NotificationState.Error -> {
                        // Show error state
                    }

                    is NotificationState.Success -> NotificationsContent(
                        result.notifications,
                        onNotificationClicked = {
                            showNotificationDetails(it)
                        },
                        onButtonNotificationClicked = {
                            showDialogNotification()
                        })
                }
            }
        }
    }

    private fun showDialogNotification() {
        findNavController().navigate(com.adidas.notifications.R.id.navigation_notifications_dialog)
    }

    private fun showNotificationDetails(it: NotificationUiEntity) {
        findNavController().navigate(com.adidas.notifications.R.id.navigation_notifications_detail_activity)
    }
}

@Composable
private fun NotificationsContent(
    notifications: List<NotificationUiEntity>,
    onNotificationClicked: (NotificationUiEntity) -> Unit,
    onButtonNotificationClicked: () -> Unit,
) {
    LazyColumn {
        items(notifications) { notification ->
            NotificationCardComposable(Modifier.clickable { onNotificationClicked(notification) }, notification, onButtonNotificationClicked)
        }
    }
}
