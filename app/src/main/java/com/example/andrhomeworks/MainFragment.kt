package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrhomeworks.databinding.FragmentMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFragment : Fragment(R.layout.fragment_main) {
    private val apiS get() = Injector.seriesApi
    private lateinit var listener : OnClicked
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        adapter = Adapter{
            listener.onClick(it.episode_id!!)
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        refreshApp()
    }

    private fun getAll(){
        apiS.getEpisodes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                adapter.setData(it)
            }
            .doOnError{
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
            .doFinally {
                binding.swipeToRefresh.isRefreshing = false
                Log.e("NCH", "refreshed")
            }
            .subscribe()
    }

    private fun refreshApp() {
        binding.swipeToRefresh.setOnRefreshListener {
            getAll()
            Toast.makeText(requireContext(), "page refreshed!", Toast.LENGTH_SHORT).show()
        }
    }
}