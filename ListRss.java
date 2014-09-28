package com.rss;

import java.util.List;

import com.data.NewsAdapter;
import com.models.RssItems;
import com.utils.Variable;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListRss extends ListActivity{

	private List<RssItems> items;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bl=getIntent().getExtras();
		int cate=bl.getInt(Variable.CATEGORIES);
		int paper=bl.getInt(Variable.PAPER);
		setTitle(Variable.CATEGORY[paper][cate]);
		int key=paper*1000+cate;
		items=Variable.newMap.get(key);
		NewsAdapter adapter=new NewsAdapter(this,Variable.Icon[paper],items);
		setListAdapter(adapter);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent=new Intent(this,NewsActivity.class);
		intent.putExtra(Variable.LINKs, items.get(position).getLink()) ;
		startActivity(intent);
	}
}
