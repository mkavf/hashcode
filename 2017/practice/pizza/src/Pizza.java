import model.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Pizza {

    private int minIngredians = 0;
    private int maxSliceSize = 0;

    private TreeSet<Cell> cellsSet = new TreeSet<>();

    private List<Slice> validMinSlices = new ArrayList<>();

    public void start(){

        minSlice(new Slice(), cells2.first(), 0);
    }


    private Slice minSlice(Slice slice, Cell start, int takeUp){
        List<Cell> cells = new ArrayList<>();

        for (Cell cell : this.getCellsFromRowAfter(start)){
            cells.add(cell);
            addUpper(cells, cell, takeUp);

            if(isValidSlice(cells)){
                return new Slice(cells);
            }
        }

        return minSlice(slice, start.getDown(), takeUp + 1);
    }

    private boolean isValidSlice(List<Cell> cells) {
        if(cells.size() > maxSliceSize){
            return false;
        }

        Map<Boolean, List<Cell>> df = cells.stream().collect(Collectors.groupingBy(Cell::isTomato));

    }

    private void addUpper(List<Cell> cells, Cell cell, int takeUp) {
        if(takeUp == 0){
            return;
        }

        Cell up = cell.getUp();
        cells.add(up);

        addUpper(cells, up, takeUp - 1);
    }
}
