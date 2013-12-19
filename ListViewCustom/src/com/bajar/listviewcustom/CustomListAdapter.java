package com.bajar.listviewcustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter{
	Item[] item;
	Context context;
	
	public CustomListAdapter(Context context, Item[] item) {
		this.context = context;
		this.item = item;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.length;
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
	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// inflating layout from the xml
		View listView;
		
		if( convertView == null) {
			listView = new View(context);
			listView = inflater.inflate(R.layout.item_layout, null); //get layout form mobile.xml

			
			ImageView itemImage = (ImageView)listView.findViewById(R.id.item_image);
			itemImage.setImageResource(item[pos].imageUrl);
			
			TextView itemName = (TextView)listView.findViewById(R.id.item_name);
			itemName.setText(item[pos].name);
			
			TextView itemStatus = (TextView)listView.findViewById(R.id.item_status);
			itemStatus.setText(item[pos].status);
		} else {
			listView = (View)convertView;
		}
		
		return listView;
	}

}
