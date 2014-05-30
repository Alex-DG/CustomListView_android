package com.example.Help;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

/*
 *  JSONParser class
 */
public class JSONParser {
	String data = "";
    JSONObject jsonObject = null; 
    JSONArray wallpapersArray = null;
    InputStream is = null;
    
	public JSONParser(){}
	
	// Download json data from url
    public JSONArray getJSONFromUrl(String strUrl) throws IOException{
    	URL url = new URL(strUrl);
		
    	//System.setProperty("http.keepAlive", "false");
    	HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); // Creating http connection to communicate with url
   
	   try {
		   
		   urlConnection.connect();    		 

		   is = urlConnection.getInputStream();
		   
           BufferedReader br = new BufferedReader(new InputStreamReader(is));
           StringBuffer sb  = new StringBuffer();

           String line = "";
           
           while( ( line = br.readLine())  != null){
               sb.append(line);
           }
           
           
           data = sb.toString();
           br.close();
           jsonObject = new JSONObject(data);
           wallpapersArray = jsonObject.getJSONArray("wallpapers");
           
	   }catch(Exception e){
           Log.d("Exception while downloading url", e.toString());
       }finally {
    	   is.close();
    	   urlConnection.disconnect();
	   }    	   
        return wallpapersArray;
    }
}
