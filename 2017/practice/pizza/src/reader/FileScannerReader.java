package reader;


import model.Cell;
import model.InputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileScannerReader {

    public InputData read() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/likewise-open/PERFECTIAL1/phamernyk/Develop/hashcode/2017/practice/pizza/file.txt"))) {
            String line = br.readLine();
            int i = 0;

            InputData result = new InputData();

            while (line != null) {
                if (i == 0) {
                    String[] items = line.split(" ");

                    result.setPizza(new Cell[Integer.valueOf(items[0])][Integer.valueOf(items[1])]);

                    result.setMinElements(Integer.valueOf(items[2]));

                    result.setMaxSize(Integer.valueOf(items[3]));
                } else {
                    line = line.toUpperCase();
                    for (int j = 0; j < line.length(); j++) {
                        result.getPizza()[i - 1][j] = new Cell(Cell.CellType.valueOf(String.valueOf(line.charAt(j))));
                    }
                }

                line = br.readLine();
                i++;
            }

            return result;

        }

    }
}
