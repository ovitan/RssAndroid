package com.rss;

import java.util.List;

import com.data.CategoryAdapter;
import com.models.RssItems;
import com.utils.RssParser;
import com.utils.Variable;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class category_activity extends ListActivity{

	private int paper;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bl=getIntent().getExtras();
		paper=bl.getInt(Variable.PAPER);
		setTitle(Variable.Papper[paper]);
		CategoryAdapter adapter=new CategoryAdapter(this,Variable.Icon[paper],Variable.CATEGORY[paper]);
		setListAdapter(adapter);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		int key=paper*1000+position;
		if(	Variable.newMap.get(key)==null)
		{
			dialog=ProgressDialog.show(category_activity.this,"", "Loading..."+Variable.CATEGORY[paper][position]);
			new categoryAsynTask().execute(position);
		}
		else
		{
			Intent inten=new Intent("com.rss.LISTRSS");
			inten.putExtra(Variable.PAPER, paper);
			inten.putExtra(Variable.CATEGORIES, position);
			startActivity(inten);
		}
	}
	class categoryAsynTask extends AsyncTask<Integer, Void, Void>
	{
       private int position;
		@Override
		protected Void doInBackground(Integer... params) {
			position=params[0];
			int key=paper*1000+params[0];
			RssParser rssp=new RssParser();
			List<RssItems> items=rssp.getListitem(Variable.LINK[paper][position]);
			Variable.newMap.put(key, items);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if(dialog!=null)
			{
				dialog.dismiss();
			}
			Intent inten=new Intent("com.rss.LISTRSS");
			inten.putExtra(Variable.PAPER, paper);
			inten.putExtra(Variable.CATEGORIES, position);
			startActivity(inten);
			super.onPostExecute(result);
		}
		
	}
}
	

