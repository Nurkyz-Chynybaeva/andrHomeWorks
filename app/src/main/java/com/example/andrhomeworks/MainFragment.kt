package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = Adapter{
            Toast.makeText(requireContext(), "item-$it", Toast.LENGTH_SHORT).show()
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        apiS.getEpisode()
            .subscribeOn(Schedulers.io())
            .map {
                val listEp = mutableListOf<Episode>()
                it.results.forEach { it ->
                    val episode = Episode(
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
                    listEp.add(episode)
                }
                listEp.toList()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                adapter.setData(it)
            }
            .doOnError{
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
            .subscribe()
    }
}