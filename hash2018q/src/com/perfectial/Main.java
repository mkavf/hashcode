package com.perfectial;

import com.perfectial.reader.InputReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = "b_should_be_easy.in";
        String outputFile = "./";


        InputData inputData = InputReader.read(inputFile);

        System.out.println(inputData);

        //Files.write(Paths.get(outputFile), text.getBytes());
    }
}
