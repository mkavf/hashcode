package model;

public class Video {
    public Video(int size, int index) {
        this.size = size;
        this.index = index;
    }

    private int size;
    private int index;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
