package com.vishnu.maptesting;

import com.bajra.maptesting.R;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class CollectionPointListFrag extends Fragment{
	ListView lvCities;
	String[] cities;
	Location[] cityLoc = new Location[3];
	
	MPI msgToParent;
	
	public interface MPI {
		void sendCityLoc(double lat, double lng);
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try {
			msgToParent = (MPI) activity;
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		View view = inflater.inflate(R.layout.frag_collection_point_list, container, false);
		cities  = new String[]{"Kathmandu", "Japan","UK"};
		cityLoc[0] = new Location("Android");
		cityLoc[0].setLatitude(27.7016900);
		cityLoc[0].setLongitude(85.3206);
		
		cityLoc[1] = new Location("Android");
		cityLoc[1].setLatitude(37.7016900);
		cityLoc[1].setLongitude(150.3206);
		
		cityLoc[2] = new Location("Android");
		cityLoc[2].setLatitude(90.7016900);
		cityLoc[2].setLongitude(88.3206);
		
		lvCities = (ListView) view.findViewById(R.id.lvCities);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, cities);
		lvCities.setAdapter(adapter);
		lvCities.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
				msgToParent.sendCityLoc(cityLoc[position].getLatitude(), cityLoc[position].getLongitude());
				
			}
		});
		
		
		return view;
	}
	
	

}
