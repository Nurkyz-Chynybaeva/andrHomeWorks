package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class AuthorisationFragment : Fragment(R.layout.authorization) {
    private lateinit var listener: CheckPref

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as CheckPref
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.edit1Aut)
        val password = view.findViewById<AppCompatEditText>(R.id.edit2Aut)
        val button = view.findViewById<AppCompatButton>(R.id.btn1Aut)

        button.setOnClickListener {
                listener.checkPrefs(login.text.toString(), password.text.toString())
            }
        }
    }
