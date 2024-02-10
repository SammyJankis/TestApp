package com.adidas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.analytics.Analytics
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {
    private val viewModel: DashboardViewModel by viewModels()

    // TODO: Move to di
    private val analytics = Analytics()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Example of how to collect and use a flow in cases where we need some
        // properties related to the view and we can't put them on upper layers.
        // This is an exception
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.text.collect { text ->
                    context?.let { context ->
                        analytics.report(context.packageName, text)
                    }
                }
            }
        }

        return ComposeView(requireContext()).apply {
            setContent {
                DashboardContent(viewModel)
            }
        }
    }
}

@Composable
private fun DashboardContent(viewModel: DashboardViewModel) {
    //Because collectAsState() is not lifecycle-aware, when putting our application in the background,
    //the coroutine will still run and flow will emit values. That's why we use collectAsStateWithLifecycle.
    val state = viewModel.text.collectAsStateWithLifecycle()
    TextComposable(state.value)
}
