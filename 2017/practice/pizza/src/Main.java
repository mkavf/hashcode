import model.InputData;
import reader.FileScannerReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        InputData inputData = new FileScannerReader().read();

        System.out.println(inputData);


    }
}
