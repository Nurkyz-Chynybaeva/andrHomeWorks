package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2) {
    private lateinit var listener : OnItemClick
    private lateinit var txt: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt = view.findViewById(R.id.txtF2)
        val textArg = arguments?.getString("key") ?: "default"
        txt.text = textArg

        val btn = view.findViewById<AppCompatButton>(R.id.btnF2)
        btn.setOnClickListener {
            listener.showSecondActivity(textArg)
        }
    }
}