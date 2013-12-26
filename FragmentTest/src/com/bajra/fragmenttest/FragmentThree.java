package com.bajra.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentThree extends Fragment{
	TextView tvTitle;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		tvTitle = (TextView) getActivity().findViewById(R.id.tvActivityTitle);
		tvTitle.setText("Framgent Three");
		return inflater.inflate(R.layout.fragmentthree, container, false);
	}
}
