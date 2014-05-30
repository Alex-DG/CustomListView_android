package com.example.samplelist;

/*
 * Define object Wallpaper
 */
public class Wallpaper {
	
	String id;
	String preview;
	String fullscreen;
	String size;	
    String tags;

    public String getId(){
    	return id;
    }
    
    public void setId(String id){
    	this.id = id;
    }
    
    public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(String fullscreen) {
        this.fullscreen = fullscreen;
    }
    
    public String getSize() {
		return size;
	}

    public void setSize(String size) {
		this.size = size;
	}

    @Override
    public String toString() {
        return "[ title=" + tags + ", fullscreen=" + fullscreen + ", size=" + size + "]";
    }

	
}
