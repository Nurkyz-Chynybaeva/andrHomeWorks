package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.database.Employee
import com.example.andrhomeworks.databinding.RegistrationFragmentBinding
import android.content.Intent

import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager

import android.R

import androidx.recyclerview.widget.RecyclerView
import com.example.andrhomeworks.database.AppDatabase


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
            addNewUserButton.setOnClickListener {

                listener.onClick()
            }

        }

    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        var userListAdapter = UserListAdapter(requireContext())
        recyclerView.adapter = userListAdapter
    }

    private fun loadUserList() {
        val db: AppDatabase = AppDatabase.getDbInstance(this.getApplicationContext())
        val userList: List<Employee> = db.employeeDao().getAll()
        userListAdapter.setUserList(userList)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == 100) {
            loadUserList()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}














