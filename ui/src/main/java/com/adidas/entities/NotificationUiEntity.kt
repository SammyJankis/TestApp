package com.adidas.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

const val bundleName = "notification"

@Parcelize
data class NotificationUiEntity(
    val title: String,
    val message: String,
) : Parcelable {
    companion object {
        fun mock() = NotificationUiEntity(title = "Title", message = "Message")
    }
}
