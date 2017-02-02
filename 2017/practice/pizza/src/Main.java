import model.InputData;
import reader.FileScanner;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        InputData inputData = new FileScanner().read();

        System.out.println(inputData);


    }
}
