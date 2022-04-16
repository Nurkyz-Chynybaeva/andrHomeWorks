package com.example.andrhomeworks.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrhomeworks.R
import com.example.andrhomeworks.databinding.FragmentMainBinding
import com.example.andrhomeworks.extensions.showToast
import com.example.andrhomeworks.ui.Event
import com.example.andrhomeworks.ui.OnClicked
import com.example.andrhomeworks.ui.details.DetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClicked
    private lateinit var adapter: Adapter
    private lateinit var vm: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClicked
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        setUpViews()
        subscribeToLiveData()
    }

    private fun setUpViews() {
        val recycler = binding.recycler
        adapter = Adapter {
            listener.openFragment(DetailsFragment.newInstance(it.id!!))
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        binding.swipeToRefresh.setOnRefreshListener {
            vm.loadCharacters()
        }
    }


    private fun subscribeToLiveData() {
        vm.charactersLiveData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        vm.event.observe(viewLifecycleOwner, {

            when (it) {
                is Event.ShowToast -> showToast(getString(it.resId))
                is Event.ShowLoadingToast -> binding.swipeToRefresh.isRefreshing = true
                is Event.ShowFinishedLoadingToast -> binding.swipeToRefresh.isRefreshing = false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}