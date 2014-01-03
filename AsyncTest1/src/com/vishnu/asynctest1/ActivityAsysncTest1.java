package com.vishnu.asynctest1;

import com.bajra.asynctest1.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityAsysncTest1 extends Activity {
	TextView tvTop, tvRes;
	Button btnStart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_asysnc_test1);
		tvTop = (TextView)findViewById(R.id.tvTop);
		btnStart = (Button)findViewById(R.id.btnStart);
		tvRes = (TextView) findViewById(R.id.tvRes);
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new MyAsync().execute();
				tvTop.setText("Wait. Keep eating the Toast");
			}
		});

	}


class MyAsync extends AsyncTask<Object, Integer, Void> {

	@Override
	protected Void doInBackground(Object... params) {
		// TODO Auto-generated method stub
		for ( int i=0;i<10; i ++){
			publishProgress(i);
			
			try{
			Thread.sleep(1000);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override 
	protected void onProgressUpdate(Integer... values ){
		int i = values[0];
		tvRes.setText(""+i);
	}
	
	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
		tvTop.setText("Completed! congrat ");
		Toast.makeText(getApplicationContext(), "Finished ", Toast.LENGTH_SHORT).show();
	}
	
} // end of the inner AsyncTask class

}// end of main class