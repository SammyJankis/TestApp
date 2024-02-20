package com.adidas.ui.list

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class NotificationsDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("This is a dialog on a notification")
            .setPositiveButton("ok") { _,_ -> }
            .create()
}
