package model;


import java.util.List;

public class InputData {
    private int videoNumber;
    private int endpointNumber;
    private int requestNumber;
    private int cacheNumber;
    private int cacheSize;


    private List<Video> videos;

    private List<Cache> caches;

    public int getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(int videoNumber) {
        this.videoNumber = videoNumber;
    }

    public int getEndpointNumber() {
        return endpointNumber;
    }

    public void setEndpointNumber(int endpointNumber) {
        this.endpointNumber = endpointNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getCacheNumber() {
        return cacheNumber;
    }

    public void setCacheNumber(int cacheNumber) {
        this.cacheNumber = cacheNumber;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Cache> getCaches() {
        return caches;
    }

    public void setCaches(List<Cache> caches) {
        this.caches = caches;
    }
}
