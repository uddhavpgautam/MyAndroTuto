package com.vishnu.fragmenttest;

import com.bajra.fragmenttest.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentOne extends Fragment{
	TextView tvTitle;
	EditText etName;
	Button btnChangeTitle;

	MsgPassingInterface msgToParent;

	public interface MsgPassingInterface{
		void sendToParent(String msg); // Let my parent Activity define this
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
		msgToParent = (MsgPassingInterface)activity;
		} catch(Exception e){
			System.out.println("Dear parent Activity! Implement my interface,\nError "+ e.getMessage());
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//inflate the layout for this fragment and return.
		View v=inflater.inflate(R.layout.fragmentone, container, false);
		tvTitle = (TextView) getActivity().findViewById(R.id.tvActivityTitle);
		tvTitle.setText("Framgent One");
		
		etName = (EditText) v.findViewById(R.id.etName);
		btnChangeTitle = (Button) v.findViewById(R.id.btnChangeTitle);
		btnChangeTitle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = etName.getText().toString();
				msgToParent.sendToParent(name);
			}
		});
		return v;
	}

}
