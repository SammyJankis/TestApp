package com.adidas.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.adidas.entities.NotificationUiEntity
import com.adidas.entities.bundleName
import com.adidas.getParcelableObject
import com.adidas.notifications.R
import com.adidas.ui.NotificationDetailComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notification = arguments?.getParcelableObject(bundleName, NotificationUiEntity::class.java)
        val message: String = notification?.message ?: arguments?.getString("message", "No message") ?: "No message"
        return ComposeView(requireContext()).apply {
            setContent {
                NotificationDetailComposable(modifier = Modifier, notificationMessage = message) {
                    onButtonNotificationDetailsChangeClicked(it)
                }
            }
        }
    }

    private fun onButtonNotificationDetailsChangeClicked(notificationMessage: String) {
        findNavController().navigate(R.id.navigation_notifications_detail_change_fragment, args = bundleOf("message" to notificationMessage))
    }
}
