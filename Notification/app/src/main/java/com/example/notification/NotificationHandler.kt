package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class NotificationHandler(private val context: Context) {
    private var notificationManager: NotificationManager? = null
    fun notificationCreate(headerText: String?, messageBodyText: String?,messageBodyTextDetailer: String?, intent: PendingIntent) {
        notificationChannelCreate()
        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.icon)
            .setContentTitle(messageBodyText)
            .setSubText(messageBodyTextDetailer)
            .setContentIntent(intent)
            .setCategory(Notification.CATEGORY_MESSAGE)
            .build()
        notificationManager?.notify(1, notificationBuilder)
    }

    fun notificationChannelCreate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (notificationManager?.getNotificationChannel(CHANNEL_ID) == null) {
                val name:CharSequence = context.getString(R.string.name)
                val description = context.getString(R.string.description)
                val importance = NotificationManager.IMPORTANCE_HIGH
                val nChannel = NotificationChannel(CHANNEL_ID, name, importance)
                nChannel.description = description

                notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager?.createNotificationChannel(nChannel)
                }
            }
        }

    companion object {
        private const val CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"
    }
    }

