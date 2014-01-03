package com.vishnu.newsreader;

import com.bajra.newsreader.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends BaseAdapter{
	Context context;
	Sites[] sites;
	
	public MyArrayAdapter(Context context,Sites[] sites) {
		this.context = context;
		this.sites = sites;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sites.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view;
		
		if(convertView == null){
			view = inflater.inflate(R.layout.sitelist, null);
			
			TextView tvItems = (TextView) view.findViewById(R.id.tvItems);
			tvItems.setText(sites[position].getSiteName());
		} else {
			view = (View) convertView;
		}
		return view;
	}

}
