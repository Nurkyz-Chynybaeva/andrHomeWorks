package com.example.andrhomeworks.ui

import androidx.fragment.app.Fragment

interface OnClicked {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true)
}