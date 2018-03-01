package com.perfectial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = "./";
        String outputFile = "./";

        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {
            stream.forEach(System.out::println);
        }

        String text = "";
        Files.write(Paths.get(outputFile), text.getBytes());
    }
}
