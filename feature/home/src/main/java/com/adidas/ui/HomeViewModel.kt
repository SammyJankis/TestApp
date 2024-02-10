package com.adidas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel : ViewModel() {

    val text: StateFlow<String> = flow {
        val data = someSuspendingFunction()
        emit(data)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = "Loading..."
    )

    private fun someSuspendingFunction(): String {
        return "This is home Fragment"
    }
}
