package com.example.googlemapsservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback{

    lateinit var mMap : GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val addFragment = childFragmentManager
            .findFragmentById(R.id.fragment)
                as SupportMapFragment
        addFragment.getMapAsync(OnMapReadyCallback { googleMap -> addFragment })

        return view
    }
    override fun onMapReady(googleMap: GoogleMap) {

        val atlanta = LatLng(33.74, 84.38)
        mMap.addMarker(
            MarkerOptions()
            .position(atlanta)
            .title("Marker in Atlanta"))
        mMap.moveCamera(
            CameraUpdateFactory
            .newLatLng(atlanta))

    }

}