package com.helicopter.ui.fragments.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.helicopter.R


class SettingsFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings_prefercens )
    }


}
