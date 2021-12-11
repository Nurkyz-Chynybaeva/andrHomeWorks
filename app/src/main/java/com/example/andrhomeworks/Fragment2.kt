package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2) {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val log = arguments?.getString("keyL", "fjie") ?: "jk"
//        val pas = arguments?.getString("keyP", "989hf") ?: "jk"

//        val text = view.findViewById<AppCompatTextView>(R.id.txtF2)
//        text.text = "$log \n $pas"
    }
}