package com.bajra.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTwo extends Fragment{
	
	TextView tvTitle;
	TextView tvMsg;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		View v =inflater.inflate(R.layout.fragmenttwo, container, false); 
		tvTitle = (TextView) getActivity().findViewById(R.id.tvActivityTitle);
		tvMsg = (TextView) v.findViewById(R.id.tvMsg); 
		String msg = tvTitle.getText().toString();
		//tvTitle.setText("Framgent Two");
	return v;
	}
	public void setTheMessage(String msg) {
		tvMsg.setText(msg);
	}
}
