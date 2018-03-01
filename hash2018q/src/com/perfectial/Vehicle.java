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
}
