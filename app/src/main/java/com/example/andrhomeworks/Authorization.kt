package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Authorization : Fragment(R.layout.autorization) {
    private lateinit var listener: OpenFrags

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OpenFrags
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.edit1Aut)
        val password = view.findViewById<AppCompatEditText>(R.id.edit2Aut)
        val button = view.findViewById<AppCompatButton>(R.id.btn1Aut)
        button.setOnClickListener {
            if (login.text.isNullOrEmpty() && password.text.isNullOrEmpty()) {
                Toast.makeText(context, "Заполните оба поля", Toast.LENGTH_SHORT).show()
            } else {
                listener.openAuthorization(login.text.toString(), password.text.toString())
            }
        }
    }
}