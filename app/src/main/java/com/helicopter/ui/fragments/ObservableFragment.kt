package com.helicopter.ui.fragments

import androidx.fragment.app.Fragment

open class ObservableFragment: Fragment() {
    override fun onStart() {
        super.onStart()
        setObservers()
    }

    open fun setObservers() {}
}