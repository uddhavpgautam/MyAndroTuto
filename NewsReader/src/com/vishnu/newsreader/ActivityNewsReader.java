package com.vishnu.newsreader;

import com.bajra.newsreader.R;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityNewsReader extends FragmentActivity {
	ListView lvSiteList;
	String url;
	Sites[] sites=new Sites[8];
	
	FragmentManager fragManager;
	FragmentTransaction fragTransaction;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_PROGRESS);
		this.setProgressBarVisibility(true);
		
		setContentView(R.layout.activity_activity_news_reader);
		
		sites[0] = new Sites("Google", "http://www.google.com");
		sites[1] = new Sites("Facebook", "http://www.fb.me");
		sites[2] = new Sites("NepalNews", "http://nepalnews.com");
		sites[3] = new Sites("Himalayan Times","http://thehimalayantimes.com");
		sites[4] = new Sites("Republica","http://myrepublica.com");
		sites[5] = new Sites("Kantipur","http://ekantipur.com");
		sites[6] = new Sites("EHN","http://ehackingnews.com");
		sites[7] = new Sites("THN", "http://thehackernews.com");
		
		fragManager = getFragmentManager();
	
		lvSiteList = (ListView) findViewById(R.id.lvSiteList);
		MyArrayAdapter adapter = new MyArrayAdapter(getApplicationContext(),sites); // can i pass layout from here
		lvSiteList.setAdapter(adapter);
		lvSiteList.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				fragTransaction = fragManager.beginTransaction();
				FragmentNewsBox newsBox = new FragmentNewsBox();
				Bundle bundle = new Bundle();
				LinearLayout llItem;
				llItem = (LinearLayout)view;
				String siteName = ((TextView)llItem.findViewById(R.id.tvItems)).getText().toString();
				for(int i=0;i< sites.length;i++){
					if( sites[i].getSiteName().compareToIgnoreCase(siteName)==0){
						url = sites[i].getSiteUrl();
					}
				}
				bundle.putString("url", url);
				//Toast.makeText(getApplicationContext(), tvView.getText().toString(),Toast.LENGTH_SHORT).show();
				newsBox.setArguments(bundle);
				
				fragTransaction.replace(R.id.flNewsBox, newsBox);
				fragTransaction.commit();
			}
		});
	}
}
