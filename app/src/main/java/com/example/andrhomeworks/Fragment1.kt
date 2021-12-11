package com.example.andrhomeworks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: Navigator
    private var Name: EditText? = null
    private var Password: EditText? = null
    private var Login: Button? = null
    private var counter = 5
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Name = view.findViewById<View>(R.id.etName) as EditText
        Password = view.findViewById<View>(R.id.etPassword) as EditText
        Login = view.findViewById<View>(R.id.btnLogin) as Button
        Login!!.setOnClickListener { onClick(Name!!.text.toString(), Password!!.text.toString()) }
    }

    private fun onClick(userName: String, userPassword: String) {
        if (userName == "Chyn" && userPassword == "2902"){
            listener.showFragment2(userName, userPassword)

            val eName = Name?.text.toString() ?: ""
            val ePass = Password?.text.toString() ?: ""
            Login?.isEnabled = eName.isNotEmpty() && ePass.isNotEmpty()
        } else {
            counter--
            if (counter == 0) {
                Login!!.isEnabled = false
            }
            Toast.makeText(requireContext(), "error!!!", Toast.LENGTH_SHORT).show()
        }
    }
}