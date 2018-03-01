package com.perfectial.reader;

import com.perfectial.InputData;
import com.perfectial.Ride;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public static InputData read(String input) {

        try (Stream<String> stream = Files.lines(Paths.get(input))) {
            List<String> data = stream.collect(Collectors.toList());

            String[] firstLine = data.get(0).split(" ");

            InputData result = new InputData();

            InputData.MainData mainData = new InputData.MainData();

            mainData.rows = Integer.parseInt(firstLine[0]);
            mainData.columns = Integer.parseInt(firstLine[1]);
            mainData.vehicles = Integer.parseInt(firstLine[2]);
            mainData.rides = Integer.parseInt(firstLine[3]);
            mainData.bonus = Integer.parseInt(firstLine[4]);
            mainData.steps = Integer.parseInt(firstLine[5]);

            result.mainData = mainData;

            result.rides = new ArrayList<>(data.size() -1);
            ArrayList<Ride>[][] endRides = new ArrayList[mainData.rows][mainData.columns];
            int koef = 100;//result.mainData.steps/result.mainData.rides*result.mainData.vehicles;
            for (int i = 1; i < data.size(); i++) {
                String[] rideData = data.get(i).split(" ");
                Ride ride = new Ride(i - 1, Integer.parseInt(rideData[0]),
                        Integer.parseInt(rideData[1]),
                        Integer.parseInt(rideData[2]),
                        Integer.parseInt(rideData[3]),
                        Integer.parseInt(rideData[4]),
                        Integer.parseInt(rideData[5])
                );
                result.rides.add(ride);
                findClosetRides(ride, endRides, koef, result);
                if (endRides[ride.endX][ride.endY] ==null){
                    endRides[ride.endX][ride.endY] = new ArrayList<>();
                }
                endRides[ride.endX][ride.endY].add(ride);

            }

            return result;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    private static void findClosetRides(Ride ride, ArrayList<Ride>[][] endRides, int koef, InputData inputData) {
        int minX = Integer.max(ride.startX - koef, 0);
        int maxX = Integer.min(ride.startX + koef, inputData.mainData.rows-1);

        int minY = Integer.max(ride.startY - koef, 0);
        int maxY = Integer.min(ride.startY + koef, inputData.mainData.columns-1);

        for (int i = minX; i<=maxX; i++){
            for (int j = minY; j<=maxY; j++){
                ArrayList<Ride> closestRides = endRides[i][j];
                if (closestRides != null){
                closestRides.forEach(r -> r.increaseNearbyRides());
            }
            }
        }
    }

    public static int getEndIndex(InputData input, Ride ride) {
        return ride.endX*input.mainData.columns+ride.endY*input.mainData.rows;
    }
   public static int getEndIndex(InputData input, int x, int y) {
        return x*input.mainData.columns+y*input.mainData.rows;
    }



}
