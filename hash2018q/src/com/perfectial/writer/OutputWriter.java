package com.perfectial.writer;

import com.perfectial.Vehicle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputWriter {

    public static void write(String outFile, List<Vehicle> vehicles) throws IOException {
        String text = "";

        for (Vehicle v: vehicles) {

            text +=  v.rides.size();

            if (vehicles.size() != 0) {

                text += " " + v.rides.stream().map(r -> String.valueOf(r.id)).collect(joining(" "));
            }

            text += "\n";
        }

        Files.write(Paths.get(outFile), text.getBytes());

    }
}
