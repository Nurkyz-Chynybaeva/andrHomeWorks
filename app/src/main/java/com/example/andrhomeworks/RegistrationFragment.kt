package com.example.andrhomeworks


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class RegistrationFragment : Fragment(R.layout.registration) {
    private lateinit var listener: CheckPref

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as CheckPref
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.edit1Reg)
        val password = view.findViewById<AppCompatEditText>(R.id.edit2Reg)
        val btn = view.findViewById<AppCompatButton>(R.id.btnReg)

        btn.setOnClickListener {
                listener.changePrefs(login.text.toString(), password.text.toString())
            }
        }
    }
