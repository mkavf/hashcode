import model.Cell;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileScannerReader {


    private final static char TOMATO = 'T';


    public Pizza read() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Projects\\hashcode\\2017\\practice\\pizza\\file.txt"))) {
            String line = br.readLine();
            int i = 0;

            Pizza result = new Pizza();

            Cell[] previousLine = null;

            while (line != null) {
                if (i == 0) {
                    String[] items = line.split(" ");
                    result.setMinIngredians(Integer.valueOf(items[2]));
                    result.setMaxSliceSize(Integer.valueOf(items[3]));
                } else {
                    line = line.toUpperCase();

                    Cell [] thisLine = new Cell[line.length()];
                    for (int j = 0; j < line.length(); j++) {
                        Cell cell = new Cell(TOMATO == line.charAt(j));
                        cell.setColumn(j);
                        cell.setRow(i);

                        result.getCellsSet().add(cell);

                        if (previousLine != null) {
                            cell.setUp(previousLine[j]);
                            previousLine[j].setDown(cell);
                        }

                        if (j > 0) {
                            cell.setLeft(thisLine[j-1]);
                            thisLine[j-1].setRight(cell);
                        }

                        thisLine[j] = cell;
                    }

                    previousLine = thisLine;

                }

                line = br.readLine();
                i++;
            }

            return result;

        }

    }
}
