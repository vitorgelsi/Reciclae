package com.example.android.recicla


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
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
        val oSujinho = LatLng(-23.5955843,-46.6851937)



        googleMap.addMarker(MarkerOptions()
            .position(barDoPedrao)
            .title("Bar do Pedrão")
            .snippet("Garrafas PET, Garrafas de Vidro")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.locais)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barDoPedrao, 12.5F))

        googleMap.addMarker(MarkerOptions()
            .position(barDoJura)
            .title("Bar do Jura")
            .snippet("Latas de Alumínio")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.locais)))

        googleMap.addMarker(MarkerOptions()
            .position(oSujinho)
            .title("O Sujinho")
            .snippet("Isopor")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.locais)))
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