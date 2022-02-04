package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.database.Employee
import com.example.andrhomeworks.databinding.AddemplFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddEmplFragment : Fragment(R.layout.addempl_fragment) {
    private lateinit var listener: OnClickButton
    private val dbInstance get() = Injector.database
    private var _binding: AddemplFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AddemplFragmentBinding.bind(view)

        binding.apply {
            btnSave.setOnClickListener {
                val e = Employee(
                    name = editName.text.toString(),
                    company = editCompany.text.toString(),
                    salary = editSalary.text.toString()
                )
                dbInstance.employeeDao().insert(e)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete {
                        Toast.makeText(requireContext(), "do on complete", Toast.LENGTH_SHORT).show()
                    }
                    .doOnError {
                        Toast.makeText(requireContext(), "do on error", Toast.LENGTH_SHORT).show()
                    }
                    .subscribe()
                listener.onClick()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
