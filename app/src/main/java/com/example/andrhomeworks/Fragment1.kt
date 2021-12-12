package com.example.andrhomeworks

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment1, container, false)
            val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarF1)

            toolbar.inflateMenu(R.menu.menu)
            toolbar.setOnMenuItemClickListener {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, Fragment2())
                        .commit()
                    Toast.makeText(requireActivity(), "About me", Toast.LENGTH_SHORT).show()

                true
            }
            return view
        }
    }