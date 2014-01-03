package com.vishnu.maptesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFrag extends SupportMapFragment{
    GoogleMap mapView;
    Bundle bundle;
    Double lat=0d,lng=0d;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		return super.onCreateView(inflater, container, savedInstance);
	}
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        mapView = getMap();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(true);
        markerOptions.position(new LatLng(lat,lng));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
        mapView.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lng)));
        mapView.addMarker(markerOptions);
    }
    public void setLatLng(Double lat, Double lng) {
    	this.lat = lat;
    	this.lng = lng;
    }

}
