package model;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    public Cache(int index, int currentSize) {
        this.index = index;
        this.currentSize = currentSize;
    }

    private int index;
    private int currentSize;
    private List<Video> videos = new ArrayList<>();

    public boolean addVideo(Video video) {
        if (currentSize - video.getSize() < 0) {
            currentSize -= video.getSize();
            return videos.add(video);
        }
        return false;
    }

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
