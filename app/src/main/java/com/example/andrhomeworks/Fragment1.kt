package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: OnClickButton
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn2 = view.findViewById<AppCompatButton>(R.id.btn2F1)
        val name = view.findViewById<AppCompatEditText>(R.id.edit1)
        val password = view.findViewById<AppCompatEditText>(R.id.edit2)
        btn2.setOnClickListener {
            if (name.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                // и? если оба поля не пустые ничего не произойдет ?
            }
        }
    }
}
