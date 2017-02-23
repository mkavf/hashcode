package model;

public class Endpoint {

    private int[] requestsToVideo;
    private int[] cacheLatency;
    private int dataCenterLatency;

    public Endpoint(int videoCount, int cacheCount) {
        requestsToVideo = new int[videoCount];
        cacheLatency = new int[cacheCount];
    }

    public int[] getRequestsToVideo() {
        return requestsToVideo;
    }

    public void setRequestsToVideo(int[] requestsToVideo) {
        this.requestsToVideo = requestsToVideo;
    }

    public int[] getCacheLatency() {
        return cacheLatency;
    }

    public void setCacheLatency(int[] cacheLatency) {
        this.cacheLatency = cacheLatency;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public void setDataCenterLatency(int dataCenterLatency) {
        this.dataCenterLatency = dataCenterLatency;
    }
}
