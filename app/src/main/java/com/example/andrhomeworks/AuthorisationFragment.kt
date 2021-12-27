package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class AuthorisationFragment : Fragment(R.layout.fragment2) {
    private lateinit var listener: OpenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OpenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.login)
        val password = view.findViewById<AppCompatEditText>(R.id.password)
        val button = view.findViewById<AppCompatButton>(R.id.auto_btn)

        button.setOnClickListener {
                listener.checkPrefs(login.text.toString(), password.text.toString())
            }
        }
    }
