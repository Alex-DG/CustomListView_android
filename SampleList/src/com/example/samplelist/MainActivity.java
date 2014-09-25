package com.example.samplelist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.example.Adapter.LazyAdapter;
import com.example.AsyncTask.JsonDownloaderTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/*
 * MainActivity class (with listView)
 */
public class MainActivity extends Activity {	
	
	//json data
	static final String url = "http://www.alexandrediguida.com/service_json_wallpapers.php";
	
	ArrayList<Wallpaper> wallpapersList = new ArrayList<Wallpaper>();
	
	ListView listV = null;
	
	LazyAdapter adapter;
	
	public final static String EXTRA_MESSAGE = "com.project.samplelist.MESSAGE";
	
	public String message = null;

    public Wallpaper wallpaperMessage = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final JsonDownloaderTask task = new JsonDownloaderTask(this);
        task.execute(url); //download json data in background
        
        listV = (ListView) findViewById(R.id.list);
        
        /*adapter = new LazyAdapter(this, wallpapersList);        
        listV.setAdapter(adapter);*/
        
        //On item click send data to the fullscreen view and open the picture
        listV.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            	Wallpaper obj =  wallpapersList.get(position); 
                message = obj.getFullscreen();

                Intent wallpaperFullScreenActivity = new Intent(MainActivity.this, FullscreenActivity.class);
                wallpaperFullScreenActivity.putExtra(EXTRA_MESSAGE, message); 
                wallpaperFullScreenActivity.putExtra("id", obj.getId());
                
                startActivity(wallpaperFullScreenActivity);             
            }
        });
	}
	
	/**
	 * Json downloader result task
	 * 
	 * @param data: json array of wallpapers
	 */
	public void jsonTaskComplete(JSONArray data)
	{
		//ArrayList<Wallpaper> wallpapersList = new ArrayList<Wallpaper>();
		
		Wallpaper w = null;
		
		String id = "";
		String preview = "";
		String fullscreen = "";
		String tags = "";
		String size = "";
		
		try {
			
			for(int indexData = 0; indexData < data.length(); indexData++)
			{
				w = new Wallpaper();			
						
				// Fetching data
				id = data.getJSONObject(indexData).getString("id");
				preview = data.getJSONObject(indexData).getString("preview");
				fullscreen = data.getJSONObject(indexData).getString("fullscreen");				
				tags = data.getJSONObject(indexData).getString("tags");
				size = data.getJSONObject(indexData).getString("size");
				
				// Setting data
				w.setId(id);
				w.setPreview(preview);
				w.setFullscreen(fullscreen);
				w.setSize(size);				
				w.setTags(tags);
				
				// Adding result as a wallpaper object in the list
				wallpapersList.add(w);					
			}			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		listV.setAdapter(new LazyAdapter(this, wallpapersList));
	}
		
}
