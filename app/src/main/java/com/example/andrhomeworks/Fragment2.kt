package com.example.andrhomeworks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast

class Fragment2 : Fragment(R.layout.fragment2) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment2, container, false)
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarF2)

        toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction() // hw-18: здесь не правильно. Нам нужно вернуться назад по стэку.
                .replace(R.id.fragmentContainer, Fragment1()) // а получится, что мы добавили в стэк новый фрагмент. Подсказска: почитай про onBackPressed()
                .commit()
            Toast.makeText(requireActivity(), "Main page", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}
