package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var listener : OnClickButton
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn1 = view.findViewById<AppCompatButton>(R.id.btn1F1)
        btn1.setOnClickListener {

        }
    }
}