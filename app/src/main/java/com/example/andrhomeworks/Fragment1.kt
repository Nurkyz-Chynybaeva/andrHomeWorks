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
    private lateinit var listener: OnClickButton
    private var Name: EditText? = null
    private var Password: EditText? = null
    private var Login: Button? = null
    private var counter = 5
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Name = view.findViewById<View>(R.id.etName) as EditText
        Password = view.findViewById<View>(R.id.etPassword) as EditText
        Login = view.findViewById<View>(R.id.btnLogin) as Button
        Login!!.setOnClickListener { onClick(Name!!.text.toString(), Password!!.text.toString()) }
    }

    private fun onClick(userName: String, userPassword: String) {
        if (userName == "Chyn" && userPassword == "2902") {
            val intent = Intent(requireContext(), MainActivity2::class.java)
            startActivity(intent)
        } else {
            counter--
            if (counter == 0) {
                Login!!.isEnabled = false
            }
            Toast.makeText(requireContext(), "error!!!", Toast.LENGTH_SHORT).show()
        }
    }
}