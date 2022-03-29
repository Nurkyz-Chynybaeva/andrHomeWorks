package com.example.andrhomeworks

import android.annotation.SuppressLint
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
import com.example.andrhomeworks.db.CharacterEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainFragment : Fragment(R.layout.fragment_main) {
    private val apiS get() = Injector.api
    private lateinit var listener: OnClicked
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        adapter = Adapter {
            listener.initDataFragment(it.id!!)
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        getAll()
    }


    private fun refreshApp() {
        binding.swipeToRefresh.setOnRefreshListener {
            getAll()
            Toast.makeText(requireContext(), "page refreshed!", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("CheckResult")
    private fun getAll() {
        apiS.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .map {
                Thread.sleep(5000)
                it
            }
            .map {
                val listChar = mutableListOf<CharacterEntity>()
                it.results.forEach {
                    val episode = CharacterEntity(
                        id = it.id,
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        type = it.type,
                        gender = it.gender,
                        origin = it.origin,
                        location = it.location,
                        image = it.image,
                        episode = it.episode,
                        url = it.url,
                        created = it.created
                    )
                    listChar.add(episode)
                }
                listChar.toList()
            }
            .map {
                dbInstance.characterDao().insertAll(it)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                binding.swipeToRefresh.isRefreshing = false
                Log.e("TAG", "refresh")
            }
            .subscribe({
                adapter.setData(it)
            }, {
                Toast.makeText(requireContext(), "error main fragment", Toast.LENGTH_SHORT).show()
            })

        dbInstance.characterDao().getAll()
            .observe(viewLifecycleOwner, {
                adapter.setData(it)
                Log.e("TAG", "episode - $it")
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}