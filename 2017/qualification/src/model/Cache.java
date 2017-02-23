package model;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private int index;

    private List<Video> videos = new ArrayList<>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getSize() {
        return GLOBAL.CACHE_SIZE - videos.stream().mapToInt(Video::getSize).sum();
    }
}
