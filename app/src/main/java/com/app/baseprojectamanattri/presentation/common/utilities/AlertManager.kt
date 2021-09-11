package com.app.baseprojectamanattri.presentation.common.utilities

import android.app.Activity
import androidx.appcompat.app.AlertDialog

object AlertManager {

    private const val ALERT_POSITIVE = 0
    private const val ALERT_NEGATIVE = 1
    private const val ALERT_NEUTRAL = 2

    fun showPositiveAlert(activity: Activity, message: String?) {
        message?.let { showAlert(activity, ALERT_POSITIVE, it) }
    }

    fun showNegativeAlert(activity: Activity, message: String?, title: String?) {
        message?.let { showAlert(activity, ALERT_NEGATIVE, it, title ) }
    }

    fun showPositiveAlertWithAction(activity: Activity, message: String,title: String?,postiveAction: ()->Unit?) {
        message?.let { showAlert(activity, ALERT_POSITIVE, it,title,postiveAction) }
    }

    private fun showAlert(
        activity: Activity,
        alertType: Int,
        message: String?,
        title: String? = "Alert",
        action: (() -> Unit?)? =null
    ) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
        message?.let { builder.setMessage(message) }
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setNegativeButton("Ok") { dialogInterface, which ->
            dialogInterface.dismiss()
            action?.invoke()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }


}