package in;


import model.InputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputDataReader {

    public InputData readData(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))){
            InputData inputData = new InputData();
            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                lineNumber++;
                if (lineNumber == 1){
                    inputData.init(nextLine);
                }

                // keep all other data
            }
            return inputData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
