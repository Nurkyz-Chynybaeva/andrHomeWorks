//package com.example.andrhomeworks
//
//import android.content.Context
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import com.example.andrhomeworks.databinding.FragmentDataBinding
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//
//class DataFragment: Fragment(R.layout.fragment_data) {
//    private val api get() = Injector.seriesApi
//    private var _binding: FragmentDataBinding ?= null
//    private val binding get() = _binding!!
//    private lateinit var listener: OnClicked
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        listener = context as OnClicked
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        _binding = FragmentDataBinding.bind(view)
//        val id = arguments?.getLong("keyId") ?: -1L
//
//        binding.apply {
//            api.getEpisode()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext {
//
//                }
//                .subscribe()
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//}