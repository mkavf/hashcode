package com.perfectial;

public class Ride{
    public int startTime;
    public int endTime;

    public int startX;
    public int startY;
    public int endX;
    public int endY;

    public int startRide;

    public Ride(int startX, int startY, int endX, int endY, int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public boolean isFinished(int t){
        return t > startRide + distance();
    }

    public int distance(){
        return Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
