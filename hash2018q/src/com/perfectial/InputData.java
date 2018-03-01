package com.perfectial;

import java.util.List;

public class InputData {

    public static class MainData {

        public int rows;

        public  int columns;

        public  int vehicles;

        public  int rides;

        public  int bonus;

        public  int steps;

        @Override
        public String toString() {
            return "MainData{" +
                    "rows=" + rows +
                    ", columns=" + columns +
                    ", vehicles=" + vehicles +
                    ", rides=" + rides +
                    ", bonus=" + bonus +
                    ", steps=" + steps +
                    "}";
        }
    }

    public MainData mainData;

    public List<Ride> rides;

    @Override
    public String toString() {
        return "InputData{" +
                "mainData=" + mainData +
                ",\n rides=" + rides +
                "} size : " + rides.size();
    }
}
