package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.andrhomeworks.databinding.FragmentDataBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DataFragment : Fragment(R.layout.fragment_data) {
    private val api get() = Injector.api
    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDataBinding.bind(view)
        val id = arguments?.getLong("KEY_ID") ?: -1L

        binding.apply {
            api.getCharacter(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    val img = imgItem
                    Glide.with(requireContext())
                        .load(it.image)
                        .into(img)
                    txtNameItem.text = it.name
                    txtStatusItem.text = it.status
                    txtSpeciesItem.text = it.species
                    txtTypeItem.text = it.type
                    txtGenderItem.text = it.gender
                    txtOriginItem.text = it.origin.name
                    txtLocationNameItem.text = it.location.url
                    txtEpisodeItem.text = it.episode.toString()
                    txtUrlItem.text = it.url
                    txtCreatedItem.text = it.created

                }
                .doOnError {
                    Toast.makeText(requireContext(), "error data fragment", Toast.LENGTH_SHORT)
                        .show()
                }
                .subscribe()
        }
    }
}