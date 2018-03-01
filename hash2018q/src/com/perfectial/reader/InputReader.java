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

            for (int i = 1; i < data.size(); i++) {
                String[] rideData = data.get(i).split(" ");
                result.rides.add(new Ride(Integer.parseInt(rideData[0]),
                        Integer.parseInt(rideData[1]),
                        Integer.parseInt(rideData[2]),
                        Integer.parseInt(rideData[3]),
                        Integer.parseInt(rideData[4]),
                        Integer.parseInt(rideData[5])
                ));
            }

            return result;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }





}
