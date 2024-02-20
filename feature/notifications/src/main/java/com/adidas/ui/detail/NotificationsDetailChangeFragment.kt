package com.adidas.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.adidas.ui.TextComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsDetailChangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                TextComposable(text = "This is a fragment to change message : ${arguments?.getString("message")} ")
            }
        }
    }
}
