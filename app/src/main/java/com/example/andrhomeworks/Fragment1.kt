package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: Navigator
    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var button: Button
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState !== null) {
            savedInstanceState.getString("key", 0.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.etName)
        password = view.findViewById<View>(R.id.etPassword) as EditText
        button = view.findViewById<View>(R.id.btnLogin) as Button
        button!!.setOnClickListener {
            onClick(
                name!!.text.toString(),
                password!!.text.toString()
            )
        }
        val with = with(name) { this?.addTextChangedListener(loginTextWatcher) }
        with(password) {
            this?.addTextChangedListener(loginTextWatcher)
        }
    }

    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = name!!.text.toString().trim { it <= ' ' }
            val passwordInput = password!!.text.toString().trim { it <= ' ' }
            button?.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty())
        }

        override fun afterTextChanged(s: Editable) {}
    }

    private fun onClick(userName: String, userPassword: String) {
        if (userName == "Chyn" && userPassword == "2902") {
            listener.showFragment2(userName, userPassword)
        } else {
            Toast.makeText(requireContext(), "error!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key", name.toString())
    }
}

