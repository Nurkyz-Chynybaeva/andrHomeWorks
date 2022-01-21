package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.MainFragmentBinding

class MainFragment: Fragment(R.layout.activity_add_new_user) {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClickButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = MainFragmentBinding.bind(view)

        binding.apply {
            val e = dbInstance.employeeDao().getById(1L)
            txtN.text = e.name
            txtC.text = e.company
            txtS.text = e.salary
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
    }
}













