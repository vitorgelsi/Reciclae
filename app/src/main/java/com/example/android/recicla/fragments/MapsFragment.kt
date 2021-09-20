package com.example.android.recicla.fragments

import android.graphics.Color
import android.graphics.Typeface
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import android.widget.TextView
import com.example.android.recicla.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val barDoPedrao = LatLng(-23.5746685,-46.6232043)
        val barDoJura = LatLng(-23.5643721,-46.652857)
        val oSujinho = LatLng(-23.5746685,-46.6232043)


        googleMap.addMarker(MarkerOptions()
            .position(barDoPedrao)
            .title("Bar do Pedrão")
            .snippet("Garrafas PET\nGarrafas de Vidro\nLatas de Alumínio")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barDoPedrao, 12.5F))

        googleMap.addMarker(MarkerOptions()
            .position(barDoJura)
            .title("Bar do Jura"))

        googleMap.addMarker(MarkerOptions()
            .position(oSujinho)
            .title("O Sujinho"))

//        googleMap.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
//            override fun getInfoWindow(arg0: Marker): View? {
//                return null
//            }
//
//            override fun getInfoContents(marker: Marker): View? {
////                val info = LinearLayout(applicationContext)
////                info.orientation = LinearLayout.VERTICAL
////
////                //--Título
////                val title = TextView(applicationContext)
////                title.setTextColor(Color.BLACK)
////                title.gravity = Gravity.LEFT
////                title.setTypeface(null, Typeface.BOLD)
////                title.text = marker.title
////
////                //--Complemento
////                val snippet = TextView(applicationContext)
////                snippet.setTextColor(Color.GRAY)
////                snippet.text = marker.snippet
////
////                //--Adiciona o titulo e o complemento na marca
////                info.addView(title)
////                info.addView(snippet)
////                return info
////            }
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}