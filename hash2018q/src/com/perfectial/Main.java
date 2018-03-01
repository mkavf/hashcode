package com.perfectial;

import com.perfectial.reader.InputReader;
import com.perfectial.writer.OutputWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = "b_should_be_easy.in";
        String outputFile = inputFile + ".out";


        InputData inputData = InputReader.read(inputFile);

        System.out.println(inputData);

        List<Vehicle> vehicles =
                Stream.generate(Vehicle::new)
                        .limit(inputData.mainData.vehicles)
                        .collect(toList());

        LinkedList<Ride> rides = new LinkedList<>(inputData.rides);
        for(int t = 0; t < inputData.mainData.steps; t++){
            for(Vehicle vehicle : vehicles){
                if(vehicle.isAvailable(t)){

                    if(rides.isEmpty()){
                        break;
                    }

                    rides.sort(new RideComparator(vehicle));

                    Ride ride = rides.removeFirst();
                    ride.startRide = t;

                    vehicle.rides.add(ride);
                }
            }
        }

        OutputWriter.write(outputFile, vehicles);
    }
}
