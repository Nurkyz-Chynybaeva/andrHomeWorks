package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.DataFragmentsBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
            dbInstance.employeeDao().getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    dName.text = it.name
                    dCompany.text = it.company
                    dSalary.text = it.salary
                }
                .doOnError {
                    Toast.makeText(requireContext(), "error data frag", Toast.LENGTH_SHORT).show()
                }
                .subscribe()

            deleteBtn.setOnClickListener {
                listener.deleteUser(id)
            }
            editBtn.setOnClickListener {
                listener.editUser(id)
            }
        }
    }
}
