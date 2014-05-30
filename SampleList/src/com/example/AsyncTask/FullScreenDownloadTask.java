package com.example.AsyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.InputStream;
import java.net.URL;

/*
 * AsyncTask to download fullscreen
 */
public class FullScreenDownloadTask extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;
    TextView textView;

    public FullScreenDownloadTask(ImageView iv) {
        imageView = iv;
    }

    @Override
    protected Bitmap  doInBackground(String... url) {
        String urlToUse = url[0];
        Bitmap bmp = null;

        try {
            InputStream in = new URL(urlToUse).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }

    protected void onPostExecute(Bitmap bmp){
        super.onPostExecute(bmp);
        imageView.setImageBitmap(bmp);
    }
}
