package com.bajra.maptesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class ActivityMapTesting extends FragmentActivity implements CollectionPointListFrag.MPI{
	boolean isMapShown=false;
	FragmentManager fragManager;
	FragmentTransaction fragTransaction;
	Bundle bundle;
	
	private MapFrag mapFrag;
	private CollectionPointListFrag collPointListFrag;

	@Override
	public void sendCityLoc(double lat, double lng) {
		// TODO Auto-generated method stub
		System.out.println("Lat Lng Received : " + lat+ lng);
		mapFrag.setLatLng(lat, lng);
		fragTransaction = fragManager.beginTransaction();
		fragTransaction.replace(R.id.flCollMap, mapFrag);
		isMapShown=true;
		fragTransaction.commit();
	}
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.activity_collection_point_map);
		mapFrag = new MapFrag();
		collPointListFrag = new CollectionPointListFrag();
		//
		fragManager = getSupportFragmentManager();
		
		fragTransaction = fragManager.beginTransaction();
		fragTransaction.add(R.id.flCollMap, collPointListFrag);

		fragTransaction.replace(R.id.flCollMap, mapFrag);
		isMapShown=true;
		fragTransaction.commit();
				
	}
	
	public void clickHandler(View v) {
		switch (v.getId() ){
		case R.id.listViewButton:
			fragTransaction = fragManager.beginTransaction();
			
			if(isMapShown){
				fragTransaction.hide(mapFrag);
				isMapShown=false;
			}
			//Someone says hide is light weight operation but isn't there any performation penalty?
			fragTransaction.replace(R.id.flCollMap, collPointListFrag,"FragCollList");
			fragTransaction.commit();
			break;
		case R.id.mapViewButton:
			isMapShown=true;
			fragTransaction = fragManager.beginTransaction();
			fragTransaction.replace(R.id.flCollMap,mapFrag,"FragMap");
			fragTransaction.commit();
			break;
		}
	}



}
