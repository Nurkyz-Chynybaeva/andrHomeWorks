package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var listener: OnButtonClicked
    private lateinit var image : AppCompatImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.imgF2)
    }
    fun getImage(img: Int) {
        image.setImageResource(img)
    }

}