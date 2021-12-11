package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar =
            view.findViewById<Toolbar>(R.id.toolbar)      //указали toolbar вместо actionBar и все свойства
        setSupportActionBar(toolbar)

    }

    private fun setSupportActionBar(toolbar: Any) {

    }
}