package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.EditFragmentBinding

class EditFragment : Fragment(R.layout.edit_fragment) {
    private lateinit var listener: OnClickButton
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditFragmentBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("KEY_ID") ?: -1L
            val e = dbInstance.employeeDao().getById(id)

            btnSave.setOnClickListener {
                e.name = editName.text.toString()
                e.company = editCompany.text.toString()
                e.salary = editSalary.text.toString()
                Toast.makeText(requireContext(), "user edited", Toast.LENGTH_SHORT).show()
                dbInstance.employeeDao().update(e)
                listener.onClick()
            }
        }
    }
}








