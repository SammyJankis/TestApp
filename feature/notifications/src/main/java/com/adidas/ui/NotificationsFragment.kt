package com.adidas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

                    is NotificationState.Success -> NotificationsContent(result.notifications)
                }
            }
        }
    }
}

@Composable
private fun NotificationsContent(notifications: List<NotificationUiEntity>) {
    LazyColumn {
        items(notifications) { notification ->
            NotificationCardComposable(notification)
        }
    }
}
