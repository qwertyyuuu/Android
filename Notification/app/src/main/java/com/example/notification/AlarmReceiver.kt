package com.example.notification

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        val pendingIntentFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        } else {PendingIntent.FLAG_UPDATE_CURRENT}

        val pendingIntent = PendingIntent.getActivity(
            context, 0, Intent(context, MainActivity::class.java), pendingIntentFlag
        )
        NotificationHandler(context!!).notificationCreate(
            intent?.extras?.getString(TEXT_HEADER),
            intent?.extras?.getString(TEXT_BODY),
            intent?.extras?.getString(TEXT_BODY2),
            pendingIntent
        )
    }

    companion object {
        const val TEXT_BODY2 = "TEXT_BODY2"
        const val TEXT_HEADER = "TEXT_HEADER"
        const val TEXT_BODY = "TEXT_BODY"

    }
}