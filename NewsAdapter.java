package com.data;

import java.util.List;

import com.models.RssItems;
import com.rss.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<RssItems>{

	private Context context;
	private List<RssItems> items;
	private int ivcon;
	
	
	public NewsAdapter(Context context, int ivcon,
			List<RssItems> items) {
		super(context, ivcon, items);
		this.context=context;
		this.ivcon=ivcon;
		this.items=items;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowview=inflater.inflate(R.layout.news, parent, false);
		
		ImageView img=(ImageView)rowview.findViewById(R.id.ivcon);
		TextView txt=(TextView)rowview.findViewById(R.id.txtnews);
		img.setBackgroundResource(ivcon);
		txt.setText(items.get(position).getTitle());
			
		return rowview;
	}
	

}
