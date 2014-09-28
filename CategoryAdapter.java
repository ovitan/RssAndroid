package com.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rss.R;

public class CategoryAdapter extends ArrayAdapter<String> {

	private Context context;
	private String[] category;
	private int ivcon;
	
	public CategoryAdapter(Context context, int ivcon,
			String[] paper) {
		super(context, ivcon, paper);
		this.context=context;
		this.category=paper;
		this.ivcon=ivcon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowview=inflater.inflate(R.layout.category, parent, false);
		
		ImageView img=(ImageView)rowview.findViewById(R.id.ivcon);
		TextView txt=(TextView)rowview.findViewById(R.id.namecate);
		img.setBackgroundResource(ivcon);
		txt.setText(category[position]);
			
		return rowview;
	}

}
