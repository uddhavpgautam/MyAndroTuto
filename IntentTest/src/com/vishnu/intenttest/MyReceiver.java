package com.vishnu.intenttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String msg = intent.getExtras().getString("msg");
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

}
