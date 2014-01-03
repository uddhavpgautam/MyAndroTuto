package com.vishnu.intenttest;

import com.bajra.intenttest.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityIntentTest extends Activity {
	private Context context;
	private EditText etUrl;
	MyReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activityintent_test);
		
		context = getApplicationContext();
		etUrl = (EditText) findViewById(R.id.etUrl);
		receiver = new MyReceiver();
	}
	
	public void clickHandler(View v){
		switch(v.getId()){
		case R.id.btnGoToNextActivity:
//			Toast.makeText(context, "Goto Activity", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, SubActivity.class);

//			Bundle bundle = new Bundle();
//			bundle.putString("name", etUrl.getText().toString());
//			intent.putExtras(bundle);

			intent.putExtra("name", etUrl.getText().toString());
			startActivity(intent);
			break;
		case R.id.btnGoToBrowser:
//			Toast.makeText(context, "Goto Browser", Toast.LENGTH_SHORT).show();
			String url = etUrl.getText().toString();
			if(!url.startsWith("http://"))
				url = "http://"+url;
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(browserIntent);
			break;
		case R.id.btnCallNow:
			String phone_no = etUrl.getText().toString();
			Intent callIntent = new Intent(Intent.ACTION_CALL);
//			Intent callIntent = new Intent(Intent.ACTION_CALL_BUTTON);
			callIntent.setData(Uri.parse("tel: "+phone_no));
			startActivity(callIntent);
			break;
		case R.id.btnSendCustomIntent:
			Intent customIntent = new Intent();
			customIntent.putExtra("msg", etUrl.getText().toString());
			customIntent.setAction("MyCustomIntent");
			sendBroadcast(customIntent);
			break;
		case R.id.btnStartReceiver:
			context.registerReceiver(receiver, new IntentFilter("MyCustomIntent"));
			//the same way we can register receiver for Battry_Low or other system intent
			break;
		case R.id.btnStopReceving:
			if(receiver != null)
				context.unregisterReceiver(receiver);
			break;
		}
	}
}
