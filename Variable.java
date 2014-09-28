package com.utils;

import java.util.HashMap;
import java.util.List;

import com.models.RssItems;
import com.rss.R;

public class Variable {

	public static final String[] Papper={"BÁO VN EXPRESS","BÁO DÂN TRÍ","BÁO NGÔI SAO","BÁO 24H.COM"};
	public static final int[] Icon={R.drawable.vnexpress,R.drawable.dantri,R.drawable.ngoisao,R.drawable.h24};
	
	
	//VNEXPRESS
	public static final String[] VNEXPRESS_CATEGORY={"Trang chủ","Thời sự","Đời sống","Thế giới","Kinh doanh"};
	public static final String[] VNEXPRESS_LINK={"http://vnexpress.net/rss/tin-moi-nhat.rss","http://vnexpress.net/rss/thoi-su.rss","http://vnexpress.net/rss/doi-song.rss","http://vnexpress.net/rss/kinh-doanh.rss"};
	
	
	public static final String[] DANTRI_CATEGORY={"Trang chủ","Thời sự","Đời sống","Thế giới","Kinh doanh"};
	public static final String[] DANTRI_LINK={"http://vnexpress.net/rss/tin-moi-nhat.rss","http://vnexpress.net/rss/thoi-su.rss","http://vnexpress.net/rss/doi-song.rss","http://vnexpress.net/rss/kinh-doanh.rss"};
	
	
	public static final String[] NGOISAO_CATEGORY={"Trang chủ","Thời sự","Đời sống","Thế giới","Kinh doanh"};
	public static final String[] NGOISAO_LINK={"http://vnexpress.net/rss/tin-moi-nhat.rss","http://vnexpress.net/rss/thoi-su.rss","http://vnexpress.net/rss/doi-song.rss","http://vnexpress.net/rss/kinh-doanh.rss"};
	
	public static final String[] H24H_CATEGORY={"Trang chủ","Thời sự","Đời sống","Thế giới","Kinh doanh"};
	public static final String[] H24H_LINK={"http://vnexpress.net/rss/tin-moi-nhat.rss","http://vnexpress.net/rss/thoi-su.rss","http://vnexpress.net/rss/doi-song.rss","http://vnexpress.net/rss/kinh-doanh.rss"};
	
	
	
	
	
	//ALL
	public static final String[][] CATEGORY={VNEXPRESS_CATEGORY,DANTRI_CATEGORY,NGOISAO_CATEGORY,H24H_CATEGORY};
	public static final String[][] LINK={VNEXPRESS_LINK,DANTRI_LINK,NGOISAO_LINK,H24H_LINK};
	
	public static final String PAPER="paper";
	public static final String CATEGORIES="category";
	public static final String LINKs="link";
	
	public static HashMap<Integer,List<RssItems>> newMap=new HashMap<Integer,List<RssItems>>();
}
