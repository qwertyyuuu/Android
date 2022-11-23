package com.example.notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.telecom.Call
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.notification.databinding.Fragment1Binding
import kotlinx.coroutines.withTimeoutOrNull
import java.util.concurrent.TimeUnit

class Fragment1 : Fragment(R.layout.fragment1) {

    private var headerText: String? = null
    private var bodyText: String? = null
    private var detailsText: String? = null

    private var timeWhenShow: Int = 0
    private var tfCheckBox = false

    private var tfHeaderEmpty = true
    private var tfBodyEmpty = true
    private var tfDetailsEmpty = true

    private var totalTime: Long = 0
    private var alarmManager: AlarmManager? = null

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)
        buttonListenerInit()
        editTextListenerInit()

    }

    fun buttonListenerInit() {
        with(binding) {
            checkBox.setOnCheckedChangeListener() { _, isChecked ->
                editTextBody2.isEnabled = isChecked
                tfCheckBox = isChecked
            }
            buttonShow.setOnClickListener {
                headerText = editTextHeader.text.toString()
                bodyText = editTextBody.text.toString()
                detailsText = if (tfCheckBox) {
                    editTextBody2.text.toString()
                } else {
                    null
                }
                timeWhenShow = Integer.valueOf(editTextTime.text.toString())

                setAlarm(timeWhenShow, headerText, bodyText, detailsText)
            }
            buttonStop.setOnClickListener {
                val timeDifferent = if (totalTime != 0L) { (totalTime - SystemClock.elapsedRealtime())/1000} else {0}
                if (timeDifferent  > 0L) {
                    alarmManager?.cancel(getPendingIntent(
                        headerText,
                        bodyText,
                        detailsText
                    ))
                    Toast.makeText(context, "Notification", Toast.LENGTH_LONG)

                } else {
                    Toast.makeText(context, "Notification", Toast.LENGTH_LONG)
                }
            }
            buttonRebootTime.setOnClickListener {
                val timeMillis = SystemClock.uptimeMillis()
                val time = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(timeMillis),
                TimeUnit.MILLISECONDS.toSeconds(timeMillis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeMillis))
                )
                Toast.makeText(context, time, Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun editTextListenerInit() {
        with(binding) {
            editTextHeader.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    tfHeaderEmpty = s?.length == 0
                }

                override fun afterTextChanged(s: Editable?) {
                    checkIfNotEmpty()
                }
            })

            editTextBody.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    tfBodyEmpty = s?.length == 0
                }

                override fun afterTextChanged(s: Editable?) {
                    checkIfNotEmpty()
                }
            })

            editTextTime.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    tfDetailsEmpty = s?.length == 0
                }

                override fun afterTextChanged(s: Editable?) {
                    checkIfNotEmpty()
                }
            })
        }
    }

    fun checkIfNotEmpty() {
        binding.buttonShow.isEnabled = !tfHeaderEmpty && !tfBodyEmpty && !tfDetailsEmpty
    }

    private fun setAlarm(
        timeWhenShow: Int,
        headerText: String?,
        bodyText: String?,
        detailsText: String?
    ) {
        alarmManager = activity?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager

        val pendingIntent = getPendingIntent(headerText, bodyText, detailsText)

        totalTime = (timeWhenShow * 1000).toLong()

        alarmManager?.set(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            totalTime,
            pendingIntent
        )
    }

    fun getPendingIntent(headerText: String?, bodyText: String?, detailsText: String?) : PendingIntent =
        Intent(context, AlarmReceiver::class.java).apply {
            putExtra(AlarmReceiver.TEXT_BODY, bodyText)
            putExtra(AlarmReceiver.TEXT_HEADER, headerText)
            putExtra(AlarmReceiver.TEXT_BODY2, detailsText)
        }.let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        }

    companion object {
        const val NOTIFICATION_ID = 1
        const val TAG = "FRAGMENT_FIRST"
        const val CHANNEL_ID = "channelID"
        fun createInstance(arguments: Bundle?) = Fragment1().apply {
            this.arguments = arguments
        }
    }


}
