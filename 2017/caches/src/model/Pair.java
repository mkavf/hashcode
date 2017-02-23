package model;

public class Pair implements Comparable<Pair>{

    public  final int endpoint;
    public final int cache;
    public final int video;

    public final double value;

    public Pair(int endpoint, int cache, int video, double value) {
        this.endpoint = endpoint;
        this.cache = cache;
        this.video = video;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (endpoint != pair.endpoint) return false;
        if (cache != pair.cache) return false;
        return video == pair.video;
    }

    @Override
    public int hashCode() {
        int result = endpoint;
        result = 31 * result + cache;
        result = 31 * result + video;
        return result;
    }

    @Override
    public int compareTo(Pair o) {
        return Double.compare(o.value, this.value);
    }
}
