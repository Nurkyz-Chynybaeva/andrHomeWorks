package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: OnButtonClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn1 = view.findViewById<AppCompatButton>(R.id.btn1F1)
        val btn2 = view.findViewById<AppCompatButton>(R.id.btn2F1)
        val btn3 = view.findViewById<AppCompatButton>(R.id.btn3F1)
        btn1.setOnClickListener {
            listener.setImage(R.drawable.jupiter)
        }
        btn2.setOnClickListener {
            listener.setImage(R.drawable.merkury)
        }
        btn3.setOnClickListener {
            listener.setImage(R.drawable.saturn)
        }
    }
}