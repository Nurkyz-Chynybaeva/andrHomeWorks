package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment1) {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar =
            view.findViewById<Toolbar>(R.id.toolbarF1)

//        toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
//        toolbar.setNavigationOnClickListener {
//            // --
//        }

        toolbar.inflateMenu(R.menu.menu)
        toolbar.setOnMenuItemClickListener {
            //
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//            R.id.menu1 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, Fragment1() )
//                    .commit()
//            }
//
//        return super.onOptionsItemSelected(item)
//    }












}