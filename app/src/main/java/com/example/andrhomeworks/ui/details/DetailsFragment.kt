package com.example.andrhomeworks.ui.details

import com.example.andrhomeworks.R
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.databinding.FragmentDetailsBinding
import com.example.andrhomeworks.ui.OnClicked
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.andrhomeworks.ui.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClicked
    private lateinit var vm: DetailsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClicked
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[DetailsViewModel::class.java]
        vm.setId(arguments?.getLong(Long::class.java.canonicalName) ?: -1)
        vm.fetchCharacter()       //------
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsBinding.bind(view)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        vm.event.observe(viewLifecycleOwner, Observer {
            when (it){
                is Event.FetchedCharacter -> fillTextViews(it.character)
            }
        }
        )
    }

    private fun fillTextViews(it: CharacterEntity) {
        with(binding) {
            Glide.with(requireContext())
                .load(it.image)
                .into(imgItem)
            txtNameItem.text = it.name
            txtStatusItem.text = it.status
            txtSpeciesItem.text = it.species
            txtGenderItem.text = it.gender
            txtEpisodeItem.text = it.episode.toString()
            txtUrlItem.text = it.url
            txtCreatedItem.text = it.created
        }
    }


    companion object {
        fun newInstance(id: Long): DetailsFragment {
            val argument = Bundle().apply {
                putLong(Long::class.java.canonicalName, id)
            }
            return DetailsFragment().apply {
                arguments = argument
            }
        }
    }
}
