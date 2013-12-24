package com.bajra.maptesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFrag extends SupportMapFragment{
    GoogleMap mapView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		super.onCreateView(inflater, container, savedInstance);		 
		//View view = inflater.inflate(R.layout.frag_map, container,false);
		return super.onCreateView(inflater, container, savedInstance);
		//return view;
	}
	
//
//    GoogleMap mapView;
//    SupportMapFragment mapFrag;
//    @Override
//    public void onCreate(Bundle arg0) {
//        super.onCreate(arg0);
//    }

//    @Override
//    public View onCreateView(LayoutInflater mInflater, ViewGroup arg1,
//            Bundle arg2) {
////    	View view;
////    	view = mInflater.inflate(R.layout.frag_map, arg1, false);
////    	
////    	mapFrag = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
//        return super.onCreateView(mInflater, arg1, arg2);
//    	//return view;
//    }
//
//    @Override
//    public void onInflate(Activity arg0, AttributeSet arg1, Bundle arg2) {
//        super.onInflate(arg0, arg1, arg2);
//    }
//
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapView = getMap();
        //mapView = getMap();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(true);
        markerOptions.position(new LatLng(23.231251f, 71.648437f));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
        mapView.addMarker(markerOptions);
    }
    
    @Override
    public void onDestroyView(){
    	super.onDestroyView();
    	System.out.println("onDestroyCalled");
    }
 
}
