package com.example.android.recicla

import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.card_lugares.view.*

class CustomInfoWindowGoogleMap(val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(p0: Marker?): View {

        var mInfoView = (context as Activity).layoutInflater.inflate(R.layout.card_lugares, null)
        var mInfoWindow: InfoWindowData? = p0?.tag as InfoWindowData?

        mInfoView.txtLocationName.text = mInfoWindow?.mLocatioName
        mInfoView.txtAddress.text = mInfoWindow?.mLocationAddres
        mInfoView.txtItensAceitos.text = mInfoWindow?.mLocationItens

        return mInfoView
    }

    override fun getInfoWindow(p0: Marker?): View? {
        return null
    }
}