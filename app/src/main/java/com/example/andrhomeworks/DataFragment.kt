package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.DataFragmentsBinding

class DataFragment : Fragment(R.layout.data_fragments) {

    private lateinit var listener: OnClickButton
    private var _binding: DataFragmentsBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = DataFragmentsBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("KEY_ID") ?: -1L
            val e = dbInstance.employeeDao().getById(id)

            dName.text = e.name
            dCompany.text = e.company
            dSalary.text = e.salary

            editBtn.setOnClickListener {
                listener.editUser(e.id!!)
            }

            deleteBtn.setOnClickListener {
                listener.deleteUser(e.id!!)
            }
        }
    }
}
