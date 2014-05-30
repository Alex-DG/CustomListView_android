package com.example.Adapter;

import java.util.ArrayList;

import com.example.AsyncTask.ImageLoader;
import com.example.samplelist.R;
import com.example.samplelist.Wallpaper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * List adapter to display data
 */
public class LazyAdapter extends BaseAdapter {
    
	private ArrayList<?> listData;
	
    private Activity activity;

    private static LayoutInflater inflater = null;
    
    public ImageLoader imageLoader;
    
    public LazyAdapter(Activity activity, ArrayList<?> listData) {
    	this.activity = activity;
        this.listData = listData;
        inflater = LayoutInflater.from(this.activity);;
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
    	return listData.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        
        if(convertView==null)
        	convertView = inflater.inflate(R.layout.list_row, null);

        TextView tags = (TextView) convertView.findViewById(R.id.tags); // tags
        TextView size = (TextView) convertView.findViewById(R.id.size); // size
        ImageView thumb_image = (ImageView) convertView.findViewById(R.id.list_image); // thumb image
        
        Wallpaper wallpaper = (Wallpaper) listData.get(position);
        
        if(tags != null){
        	tags.setText(wallpaper.getTags());         
        }
        if(size != null){
        	size.setText(wallpaper.getSize());        	
        }
        if(thumb_image != null){
        	imageLoader.DisplayImage(wallpaper.getPreview(), thumb_image);
        }

        return convertView;
    }
}