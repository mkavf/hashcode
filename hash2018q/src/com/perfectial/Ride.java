package com.perfectial;

public class Ride {
    public int startX;
    public int startY;
    public int endX;
    public int endY;

    public int startTime;
    public int endTime;

    public int startRide;

    public Ride(int startX, int startY, int endX, int endY, int startTime, int endTime) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "}\n";
    }

    public boolean isFinished(int t){
        return t > startRide + distance();
    }

    public int distance(){
        return Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
