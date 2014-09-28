package com.utils;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.models.RssItems;

public class RssParser {

	public List<RssItems> getListitem(String Link) 
	{

      try
      {
//    	  URL utl=new URL(Link);
//    	  InputSource source=new InputSource(utl.openStream());
//    	  SAXParserFactory factory=SAXParserFactory.newInstance();
//    	  SAXParser paser=factory.newSAXParser();
//    	  XMLReader reader=paser.getXMLReader();
//    	  RssHandler handeler=new RssHandler();
//    	  reader.setContentHandler(handeler);
//
//    	  reader.parse(source);
//    	  return handeler.getListitem();
    	  try {
    		  
              DefaultHttpClient httpclient = new DefaultHttpClient();
              
              HttpGet httpget = new HttpGet(Link);
              HttpResponse response = httpclient.execute(httpget);
              HttpEntity entity = response.getEntity();
              
              SAXParserFactory factory = SAXParserFactory.newInstance();
              factory.setValidating(false);
              
              SAXParser parser = factory.newSAXParser();
              XMLReader reader = parser.getXMLReader();
              
              RssHandler handler = new RssHandler();
              reader.setContentHandler(handler);

              InputSource inStream = new InputSource();
              inStream.setCharacterStream(new StringReader(EntityUtils.toString(entity)));
              
              reader.parse(inStream);
              return handler.getListitem();
              
          } catch (MalformedURLException e) {
              e.printStackTrace();
              // result.setText("Cannot connect RSS!");
              return null;
          } catch (ParserConfigurationException e) {
              e.printStackTrace();
              // result.setText("Cannot connect RSS!");
              return null;
          } catch (SAXException e) {
              e.printStackTrace();
              // result.setText("Cannot connect RSS!");
              return null;
          } catch (IOException e) {
              e.printStackTrace();
              // result.setText("Cannot connect RSS!");
              return null;
          }
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
    	  return null;
      }
	}

}

