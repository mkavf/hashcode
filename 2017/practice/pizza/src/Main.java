import model.InputData;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Pizza inputData = new FileScannerReader().read();

        System.out.println(inputData);


    }
}
