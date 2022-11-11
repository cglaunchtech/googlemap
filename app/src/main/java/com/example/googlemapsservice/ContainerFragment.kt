package com.example.googlemapsservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_container.view.*


class ContainerFragment : Fragment() {

    private val mFragment = MapFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_container, container, false)

        replaceFragment(mFragment)
        view.bottom_nav.selectedItemId = R.id.mapFragment
        view.bottom_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.mapFragment -> replaceFragment(mFragment)
            }
            true
        }

    return view
    }
    private fun replaceFragment(fragment : Fragment) {

        val transaction = parentFragmentManager
        transaction.beginTransaction().replace(
            R.id.fragment_container,
            fragment
        ).commit()
    }
}