package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Fragment1 : Fragment(R.layout.fragment1) {

    private lateinit var listener: Navigator
    private lateinit var name: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var button: Button
    private lateinit var nameLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout

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
        password = view.findViewById(R.id.etPassword)
        button = view.findViewById<AppCompatButton>(R.id.btnLogin)
        nameLayout = view.findViewById(R.id.nameLayout)
        passwordLayout = view.findViewById(R.id.passworLayout)

        button.setOnClickListener {
            onClick(
                name.text.toString(),
                password.text.toString()
            )
        }
        with(name) { this.addTextChangedListener(loginTextWatcher) }
        with(password) {
            this.addTextChangedListener(loginTextWatcher)
        }
    }

    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = name.text.toString().trim { it <= ' ' }
            val passwordInput = password.text.toString().trim { it <= ' ' }
            button.isEnabled = usernameInput.isNotEmpty() && passwordInput.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable) {}
    }

    private fun onClick(userName: String, userPassword: String) {
        if (userName == "Chyn" && userPassword == "2902") {
            listener.showFragment2(userPassword, userName)
        } else {
            nameLayout.error = "Wrong username or password :)"
            passwordLayout.error = "Wrong username or password :)"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key", name.toString())
    }
}

