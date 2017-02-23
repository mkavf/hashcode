package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cache {

    public Cache(int index, int currentSize) {
        this.index = index;
        this.currentSize = currentSize;
    }

    private int index;
    private int currentSize;
    private Set<Integer> videos = new HashSet<>();
    private List<Integer> endpoint = new ArrayList<>();

    public boolean addVideo(Video video) {
        if (currentSize - video.getSize() >= 0 && !videos.contains(video.getIndex())) {
            currentSize -= video.getSize();
            return videos.add(video.getIndex());
        }
        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Set<Integer> getVideos() {
        return videos;
    }

    public void addEndpoint(int i){
        endpoint.add(i);
    }
    public List<Integer> getLinkedEndpoints() {
        return endpoint;
    }
}
