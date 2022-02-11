package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.EdituserFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EditUserFragment : Fragment(R.layout.edituser_fragment) {
    private lateinit var listener: OnClickButton
    private var _binding: EdituserFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EdituserFragmentBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("KEY") ?: -1L
            dbInstance.employeeDao().getById(id)

            btnSave.setOnClickListener {
                updateUser(id)
            }
        }
    }

    private fun updateUser(id: Long) {
        dbInstance.employeeDao().getById(id)
            .subscribeOn(Schedulers.io())
            .flatMapCompletable {
                it.name = binding.editName.text.toString()
                it.company = binding.editCompany.text.toString()
                it.salary = binding.editSalary.text.toString()
                dbInstance.employeeDao().update(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {

                Toast.makeText(context, "user updated", Toast.LENGTH_SHORT).show()
                listener.onClick()
            }
            .subscribe()
    }
}
