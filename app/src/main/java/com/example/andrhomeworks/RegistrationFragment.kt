package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.database.Employee
import com.example.andrhomeworks.databinding.RegistrationFragmentBinding

class RegistrationFragment : Fragment(R.layout.registration_fragment) {

    private var _binding: RegistrationFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClickButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = RegistrationFragmentBinding.bind(view)
        binding.apply {
            btn.setOnClickListener {
                val e = Employee(
                    name = editN.text.toString(),
                    company = editC.text.toString(),
                    salary = editS.text.toString()
                )
                dbInstance.employeeDao().insert(e)
                listener.onClick()

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}














