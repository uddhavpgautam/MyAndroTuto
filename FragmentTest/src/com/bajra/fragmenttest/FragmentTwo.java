package com.bajra.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment{
	TextView tvTitle;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

		tvTitle = (TextView) getActivity().findViewById(R.id.tvActivityTitle);
		tvTitle.setText("Framgent Two");
	return inflater.inflate(R.layout.fragmenttwo, container, false);
	}
	
}
