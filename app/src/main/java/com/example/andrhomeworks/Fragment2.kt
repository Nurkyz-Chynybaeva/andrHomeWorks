package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.Toast

class Fragment2 : Fragment(R.layout.fragment2) {
    private lateinit var listener : Back

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Back
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarF2)
        toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(requireActivity(), "Main page", Toast.LENGTH_SHORT).show()
            requireActivity().onBackPressed()
        }
    }
}