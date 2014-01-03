package com.vishnu.intenttest;

import com.bajra.intenttest.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SubActivity extends Activity {
	Intent intent;
	Context context;
	TextView tvName;
	Bundle bundle;
	
	
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		tvName = (TextView) findViewById(R.id.tvName);
		
		intent = this.getIntent();
		bundle = intent.getExtras();
		name = bundle.getString("name");
		tvName.setText(name);
		
	}
}
