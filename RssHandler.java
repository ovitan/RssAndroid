package com.utils;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.models.RssItems;

public class RssHandler extends DefaultHandler{
	
	public static final String ITEMS="item";
	public static final String TITLE="title";
	public static final String DESCIPTION="description";
	public static final String DATE="pubDate";
	public static final String LINK="link";

	private RssItems item;
	private List<RssItems> listitem=new ArrayList<RssItems>();
	private boolean check=false;
	private StringBuilder sbuider=new StringBuilder();
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(check && (sbuider!=null))
		{
			sbuider.append(ch,start,length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(localName.equalsIgnoreCase(ITEMS))
		{
			listitem.add(item);
			
		}else if(check)
			{
			  if(localName.equalsIgnoreCase(TITLE))
			  {
				  item.setTitle(sbuider.toString().trim());
			  }
			  else if(localName.equalsIgnoreCase(DESCIPTION))
			  {
				  item.setDesciptions(sbuider.toString().trim());
			  }
			  else if(localName.equalsIgnoreCase(DATE))
			  {
				  item.setDate(sbuider.toString().trim());
			  }
			  else if(localName.equalsIgnoreCase(LINK))
			  {
				  item.setLink(sbuider.toString().trim());
			  }
			  sbuider=new StringBuilder();
			}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		
		if(localName.equalsIgnoreCase(ITEMS))
		{
			item=new RssItems();
			check=true;	
		}

	}

	public List<RssItems> getListitem() {
		return listitem;
	}

	
}
