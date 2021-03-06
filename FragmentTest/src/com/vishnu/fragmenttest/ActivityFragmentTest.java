package com.vishnu.fragmenttest;

import com.bajra.fragmenttest.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityFragmentTest extends FragmentActivity implements FragmentOne.MsgPassingInterface{
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	Button btnChangeFrag;
	FragmentOne fragOne;
	FragmentTwo fragTwo;
	int count;
	
	public void sendToParent(String msg) {
		System.out.println(msg + "Received from parent");
		fragTwo.setTheMessage(msg);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.detailfrag);
		setContentView(R.layout.activity_activity_fragment_test);
		
		count = 0;
		fragmentManager = getFragmentManager();
		btnChangeFrag = (Button) findViewById(R.id.btnChangeFrag);
		btnChangeFrag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				count ++;
				fragOne = new FragmentOne();
				fragTwo = new FragmentTwo();
				FragmentThree fragThree = new FragmentThree();
				
				fragmentTransaction = fragmentManager.beginTransaction();
				if(count%2==0) {
					fragmentTransaction.replace(R.id.flFragOne, fragOne);
					fragmentTransaction.replace(R.id.flFragTwo, fragTwo);
				} else {
					fragmentTransaction.replace(R.id.flFragOne, fragTwo);
					fragmentTransaction.replace(R.id.flFragTwo, fragThree);
				}
				//fragmentTransaction.add(R.id.flFragTwo, myFrag);
				fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});
		
	}
	@Override
	public void onBackPressed(){
		fragmentManager.popBackStack();
	}

}
