package com.example.AsyncTask;

import java.io.IOException;

import org.json.JSONArray;

import com.example.Help.JSONParser;
import com.example.samplelist.MainActivity;

import android.os.AsyncTask;

/*
 * AsyncTask to download JSON data
 */
public class JsonDownloaderTask extends AsyncTask<String, String, JSONArray> {

    MainActivity ma;

    public JsonDownloaderTask(MainActivity main){
        ma = main;
    }

    @Override
    protected JSONArray doInBackground(String... url) {
    	JSONParser jParser = new JSONParser();
        // Getting JSON from URL
    	JSONArray jsonArray = null;
		try {
			jsonArray = jParser.getJSONFromUrl(url[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return jsonArray;        
    }

    protected void onPostExecute(JSONArray data){

    	//send data to result method in main activity
        ma.jsonTaskComplete(data);
    }
}
