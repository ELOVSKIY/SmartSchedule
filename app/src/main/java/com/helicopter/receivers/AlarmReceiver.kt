package com.helicopter.receivers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.provider.AlarmClock
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.helicopter.R

private const val ALARM_NOTIFICATION_ID = 1
private const val PENDING_INTENT_REQUEST_CODE = 1

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(
                context.getString(R.string.alarm_notification_channel),
                context.getString(R.string.alarm_notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            ).apply { 
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                description = context.getString(R.string.alarm_notification_channel_description)
            }
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm")
        intent.putExtra(AlarmClock.EXTRA_HOUR, 10)
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        val pendingIntent = PendingIntent.getActivity(context, PENDING_INTENT_REQUEST_CODE, intent, 0)

        
        val builder = NotificationCompat
            .Builder(context, context.getString(R.string.alarm_notification_channel))
        builder.apply { 
            priority = NotificationCompat.PRIORITY_HIGH
            setContentTitle(context.getString(R.string.alarm_notification_title))
            setSmallIcon(R.drawable.ic_alarm_24_svg)
            setAutoCancel(true)
            addAction(R.mipmap.ic_launcher, context.getString(R.string.set_alarm),
                pendingIntent)
        }
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.notify(ALARM_NOTIFICATION_ID, builder.build())
    }
}

