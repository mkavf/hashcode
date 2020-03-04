import model.Cell;
import model.Pizza;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileScannerReader {


    private final static char TOMATO = 'T';


    public Pizza read(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int i = 0;

            Pizza result = new Pizza();

            int countTomato = 0;

            while (line != null) {
                if (i == 0) {
                    String[] items = line.split(" ");
                    result.setMinIngredians(Integer.valueOf(items[2]));
                    result.setMaxSliceSize(Integer.valueOf(items[3]));
                    result.setRows(Integer.valueOf(items[0]));
                    result.setCollsAmount(Integer.valueOf(items[1]));

                    result.setCellsArr(new Cell[result.getRows()][result.getColls()]);
                } else {
                    line = line.toUpperCase();

                    int rowIndex = i - 1;

                    Cell [] thisLine = new Cell[line.length()];
                    for (int j = 0; j < result.getColls(); j++) {
                        Cell cell = new Cell(TOMATO == line.charAt(j));

                        result.getCellsArr()[rowIndex][j] = cell;

                        if (cell.isTomato()) {
                            countTomato++;
                        }

                        cell.setColumn(j);
                        cell.setRow(rowIndex);
                        cell.setIndex(rowIndex*result.getColls()+j);
                        result.getCellsSet().add(cell);

                        if (rowIndex != 0) {
                            cell.setUp(result.getCellsArr()[rowIndex][j]);
                            result.getCellsArr()[rowIndex][j].setDown(cell);
                        }

                        if (j > 0) {
                            cell.setLeft(thisLine[j-1]);
                            thisLine[j-1].setRight(cell);
                        }

                        thisLine[j] = cell;
                    }
                }

                line = br.readLine();
                i++;
            }

            int lessCount = Math.min(countTomato, result.getColls() * result.getRows() - countTomato);

            result.setMaxSlicesCount(lessCount / result.getMinIngredians());

            return result;

        }

    }
}
