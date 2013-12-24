package com.bajra.maptesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.bajra.maptesting.R;

public class CollectionPointListMapActivity1 extends FragmentActivity{

	private Button mapButton;
	private Button listButton;
	FragmentManager fragManager;
	FragmentTransaction fragTransaction;
	
	private MapFrag mapFrag;
	private Fragment mFrag;
	private CollectionPointListFrag collPointListFrag;

	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.collection_point_map);
		fragManager = getSupportFragmentManager();

		
		mapFrag = new MapFrag();
		collPointListFrag = new CollectionPointListFrag();
		
		mapButton = (Button) findViewById(R.id.mapViewButton);
		listButton = (Button) findViewById(R.id.listViewButton);
		
	}
	
	public void clickHandler(View v) {
		switch (v.getId() ){
		case R.id.listViewButton:
			fragTransaction = fragManager.beginTransaction();
			fragTransaction.replace(R.id.flCollMap, collPointListFrag);
			fragTransaction.commit();
			break;
		case R.id.mapViewButton:
			fragTransaction = fragManager.beginTransaction();
			fragTransaction.replace(R.id.flCollMap, mFrag);
			fragTransaction.commit();
			break;
		}
	}
	
	
}
