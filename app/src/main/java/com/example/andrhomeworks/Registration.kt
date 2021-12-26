package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment


class Registration : Fragment(R.layout.registration) {
    private lateinit var listener: OpenFrags

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OpenFrags
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<AppCompatButton>(R.id.btnReg)
        val editLog = view.findViewById<AppCompatEditText>(R.id.edit1Reg)
        val editPas = view.findViewById<AppCompatEditText>(R.id.edit2Reg)

        btn.setOnClickListener {
//            preferences.saveLogin(editLog.text.toString())
//            preferences.savePassword(editPas.text.toString())
//
//            listener.openRegistration()
        }
    }
}