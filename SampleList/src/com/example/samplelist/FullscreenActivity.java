package com.example.samplelist;

import java.io.IOException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.AsyncTask.FullScreenDownloadTask;

/*
 * FullScreen Activity
 */
public class FullscreenActivity extends Activity {

	ImageView fullscreen = null;
    String messageFullScreen = null;
    String id = null;
    Object tags = null;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
		
		fullscreen = (ImageView) findViewById(R.id.fullscreen);
		
		Intent intent = getIntent();
		
		// Get extra message from mainActivity
		messageFullScreen = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		id = intent.getStringExtra("id");
		tags = intent.getStringArrayExtra("tags");
		
		//AsyncTask to download fullscreen pic
		FullScreenDownloadTask task = new FullScreenDownloadTask(fullscreen);
		task.execute(messageFullScreen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fullscreen, menu);
		return true;
	}
	
	/*
     * onPostExecute answer display fullscreen
     */
    public void onBackgroundTaskComplete(String fullscreenpath) throws IOException {
        URL newurl = new URL(fullscreenpath);
        Bitmap mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
        fullscreen.setImageBitmap(mIcon_val);
    }
}
