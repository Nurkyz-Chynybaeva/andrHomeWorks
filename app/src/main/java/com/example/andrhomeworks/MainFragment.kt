package com.example.andrhomeworks
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
class MainFragment : Fragment(R.layout.fragment1) {
    private lateinit var listener: Back
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Back
    }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment1, container, false)
            val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarF1)
            toolbar.inflateMenu(R.menu.menu)
            toolbar.setOnMenuItemClickListener {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, AboutFragment())
                        .addToBackStack(null)
                        .commit()
                    Toast.makeText(requireActivity(), "About me", Toast.LENGTH_SHORT).show()
                true
            }
            return view
        }
    }