package com.vishnu.listviewcustom;

import com.bajar.listviewcustom.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	Item[] items= new Item[3];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		items[0] = new Item("Chair","GooD",R.drawable.mob1);
		items[1] = new Item("Bed","Wrost", R.drawable.mob2);
		items[2] = new Item("Book", "Fine", R.drawable.mob3);
		
		ListView lvItem = (ListView)findViewById(R.id.lvItems);
		lvItem.setAdapter(new CustomListAdapter(getApplicationContext(), items));
	
	}

}
