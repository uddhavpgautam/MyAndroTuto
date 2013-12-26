package com.bajra.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOne extends Fragment{
	TextView tvTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//inflate the layout for this fragment and return.
		tvTitle = (TextView) getActivity().findViewById(R.id.tvActivityTitle);
		tvTitle.setText("Framgent One");
		
		return inflater.inflate(R.layout.fragmentone, container, false);
	}
	
}
