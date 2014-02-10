package com.example.fbsharedialogtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FbShareMain extends Activity {
	Button btnShare;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fb_share_main);
		
		btnShare = (Button)findViewById(R.id.btnShare);
		btnShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle params=new Bundle();
				params.putString("name", "Test name Here");
			    params.putString("caption", "Caption Caption ");
			    params.putString("link", "https://www.facebook.com/ikringloop");
			    params.putString("picture", "http://www.hdwallpaperspin.com/wp-content/uploads/2013/06/101.jpg");
				
				Intent intent = new Intent(getApplicationContext(),ShareDialog.class);
				intent.putExtras(params);
				startActivity(intent);
			}
		});
	}

	

}
