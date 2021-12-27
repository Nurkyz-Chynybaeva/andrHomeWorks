package com.example.andrhomeworks


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class RegistrationFragment : Fragment(R.layout.registration) {
    private lateinit var listener: OpenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OpenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newLogin = view.findViewById<AppCompatEditText>(R.id.new_login)
        val newPassword = view.findViewById<AppCompatEditText>(R.id.new_password)
        val newButton = view.findViewById<AppCompatButton>(R.id.new_btn)

        newButton.setOnClickListener {
                listener.changePrefs(newLogin.text.toString(), newPassword.text.toString())
            }
        }
    }
