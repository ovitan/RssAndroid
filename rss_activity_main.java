package com.rss;


import com.data.PaperAdapter;
import com.utils.*;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class rss_activity_main extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PaperAdapter adapter=new PaperAdapter(this,R.id.txtname, Variable.Papper);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent inten=new Intent("com.rss.CATEGORY");
		inten.putExtra(Variable.PAPER,position);
		startActivity(inten);
		
	}

	
}
