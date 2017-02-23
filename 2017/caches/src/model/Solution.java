package model;


import java.util.List;

public class Solution {
    public final List<Cache> filledCaches;

    public Solution(List<Cache> filledCaches) {

        this.filledCaches = filledCaches;
    }

    public long getUsedCaches() {
        return filledCaches
                .stream()
                .filter(c -> c.getVideos().size() > 0)
                .count();
    }
}
