package com.helicopter.ui.fragments.settings

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.helicopter.R
import com.helicopter.receivers.AlarmReceiver
import java.util.*


class SettingsFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings_prefercens )

        val setAlarmSwitch = findPreference<SwitchPreference>("USE_ALARM_SWITCH")

        val time = findPreference<Preference>("SET_ALARM")
        time?.setOnPreferenceClickListener {
//            val timeAlert = TimePickerDialog(context,{_,_,_ ->
//
//            }, 12, 0, false)
//            timeAlert.show()
           setAlarmManager()

            true
        }
    }

    private fun setAlarmManager(){
        val alarmMgr = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, 0)
        }

        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }

        alarmMgr.set(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            alarmIntent
        )
    }


}
