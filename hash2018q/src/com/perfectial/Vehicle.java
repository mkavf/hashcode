package com.perfectial;

import java.util.LinkedList;

public class Vehicle {
    public LinkedList<Ride> rides = new LinkedList<>();

    public boolean isAvailable(int t){
        if(rides.isEmpty()){
            return true;
        }

        Ride last = rides.getLast();

        return last.isFinished(t);
    }

    public int distance(Ride ride){
        if(rides.isEmpty()){
            return Math.abs(0 - ride.startX) + Math.abs(0 - ride.startY);
        }

        Ride last = rides.getLast();

        return Math.abs(last.endX - ride.startX) + Math.abs(last.endY - ride.startY);
    }
}
