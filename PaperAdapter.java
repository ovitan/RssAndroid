package com.data;

import com.rss.R;
import com.utils.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PaperAdapter extends ArrayAdapter<String> {

	private Context context;
	@SuppressWarnings("unused")
	private String[] papper;
	
	public PaperAdapter(Context context, int resource,
			String[] paper) {
		super(context, resource, paper);
		this.context=context;
		this.papper=paper;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowview=inflater.inflate(R.layout.paper, parent, false);
		
		ImageView img=(ImageView)rowview.findViewById(R.id.img);
		TextView txt=(TextView)rowview.findViewById(R.id.txtname);
		img.setBackgroundResource(Variable.Icon[position]);
		txt.setText(Variable.Papper[position]);
			
		return rowview;
	}
	

}
