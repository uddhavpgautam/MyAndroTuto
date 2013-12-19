package com.bajra.custsomsipnner1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityCustomSpinner1 extends Activity {
	Spinner spinCountry;
	String[] country = new String[]{"Nepal","Cuba","North Korea","India"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_custom_spinner1);
		
		spinCountry = (Spinner) findViewById(R.id.spinCountry);
		ArrayAdapter<String> adapter = new MyAdapter(getApplicationContext(), country);
		spinCountry.setAdapter(adapter);
	}
	public class MyAdapter extends ArrayAdapter<String>{
		String[] items;
		public MyAdapter(Context context, String[] items){
			super(context, R.layout.custom_spinner, items);
			this.items = items; 
		}
		@Override
		public View getView(int pos, View cnvtView, ViewGroup parent){
			return getCustomView(pos, cnvtView, parent);
		}
		
		@Override
		public View getDropDownView(int pos, View cnvtView, ViewGroup parent) {
			return getCustomView(pos, cnvtView, parent);
		}
		public View getCustomView(int pos, View cnvtView, ViewGroup parent){
			LayoutInflater inflater = getLayoutInflater();
			View mySpinner = inflater.inflate(R.layout.custom_spinner, parent, false);
			
			TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
			main_text.setText(items[pos]);

			return mySpinner;
		}
	}

}
