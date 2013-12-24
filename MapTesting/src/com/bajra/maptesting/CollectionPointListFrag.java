package com.bajra.maptesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class CollectionPointListFrag extends Fragment{
	LinearLayout llCollList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		View view = inflater.inflate(R.layout.frag_collection_point_list, container, false);
		
		llCollList = (LinearLayout) view.findViewById(R.id.llCollList);
		return view;
	}
	
	@Override
	public void onResume (){
		super.onResume();
		System.out.println("OnResume called");
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		System.out.println("onActivityCreated called");
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		System.out.println("onCrate called");
		
	}
	 @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        System.out.println("curChoice");
	    }

		

}
