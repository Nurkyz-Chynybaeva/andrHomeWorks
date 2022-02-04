package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.databinding.DeleteuserFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DeleteUserFragment : Fragment(R.layout.deleteuser_fragment) {
    private lateinit var listener: OnClickButton
    private var _binding: DeleteuserFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = DeleteuserFragmentBinding.bind(view)

        val id = arguments?.getLong("KEY_D") ?: -1L
        dbInstance.employeeDao().getById(id)

        binding.btn1D.setOnClickListener {
            dbInstance.employeeDao().delete(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    Toast.makeText(requireContext(), "user deleted", Toast.LENGTH_SHORT).show()
                    listener.onClick()
                }
                .doOnError {
                    Toast.makeText(requireContext(), "user is not deleted", Toast.LENGTH_SHORT)
                        .show()
                }
                .subscribe()

        }
        binding.btn2D.setOnClickListener {
            listener.onClick()
        }
    }
}