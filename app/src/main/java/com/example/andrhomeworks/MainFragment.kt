package com.example.andrhomeworks
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
class MainFragment : Fragment(R.layout.fragment1) { // почему все слеплено) отформатировать бы
    private lateinit var listener: Back // нигде не используется
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Back
    }
        override fun onCreateView( // работу с вьюшками лучше делать в onViewCreated()
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
