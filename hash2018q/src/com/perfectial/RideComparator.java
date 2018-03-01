package com.perfectial;

import java.util.Comparator;

public class RideComparator implements Comparator<Ride>{

    private Vehicle vehicle;

    public RideComparator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int compare(Ride o1, Ride o2) {
        int score1 = vehicle.distance(o1) + o1.startTime;
        int score2 = vehicle.distance(o2) + o2.startTime;

        int score3 = Integer.compare(score1, score2);

        if(score3 == 0){
            return Integer.compare(o1.distance(), o2.distance());
        }

        return score3;
    }
}
