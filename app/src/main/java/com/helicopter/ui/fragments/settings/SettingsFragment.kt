package com.helicopter.ui.fragments.settings

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.helicopter.R


class SettingsFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings_prefercens )

        val setAlarmSwitch = findPreference<SwitchPreference>("USE_ALARM_SWITCH")

        val time = findPreference<Preference>("SET_ALARM")
        time?.setOnPreferenceClickListener {
            val timeAlert = TimePickerDialog(context,{_,_,_ ->

            }, 12, 0, false)
            timeAlert.show()
            true
        }
    }


}
