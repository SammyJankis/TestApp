package com.adidas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class NotificationsFragment : Fragment() {
    private val viewModel: NotificationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NotificationsContent(viewModel)
            }
        }
    }
}

@Composable
private fun NotificationsContent(viewModel: NotificationsViewModel) {
    val state = viewModel.text.collectAsStateWithLifecycle()
    TextComposable(state.value)
}
