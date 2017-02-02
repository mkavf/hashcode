import model.Cell;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Pizza {

    private int minIngredians = 0;
    private int maxSliceSize = 0;

    private int rows;
    private int collsAmount;

    private TreeSet<Cell> cellsSet = new TreeSet<>();
    private Cell[][] cellsArr;

    private List<Slice> validMinSlices = new ArrayList<>();
    private double maxSlicesCount;

    public void start() {
        Slice slice;
        do {
            slice = minSlice(cellsSet.first(), 0);
            if (Objects.nonNull(slice)) {
                validMinSlices.add(slice);
            }
        } while (validMinSlices.size() == maxSlicesCount || Objects.isNull(slice));
    }

    private Slice minSlice(Cell start, int takeUp) {
        List<Cell> cells = new ArrayList<>();

        for (Cell cell : this.getCellsFromRowAfter(start)) {
            if (canAdd(cells)) {
                cells.add(cell);
                addUpper(cells, cell, takeUp);

                if (isValid(cells)) {
                    cellsSet.removeAll(cells);
                    return new Slice(cells);
                }
            }
            break;
        }
        if (start.getRow() < rows - 1) {
            return minSlice(getDown(start), takeUp + 1);
        }
        return null;
    }

    private List<Cell> getCellsFromRowAfter(Cell start) {
        List<Cell> row = new ArrayList<>();
        for (int i = start.getCol(); i < collsAmount; i++) {
            row.add(cellsArr[start.getRow()][i]);
        }
        return row;
    }

    private boolean canAdd(List<Cell> cells) {
        return cells.size() < maxSliceSize;
    }

    private boolean isValid(List<Cell> cells) {
        Map<Boolean, List<Cell>> df = cells.stream().collect(Collectors.groupingBy(Cell::isTomato));

        if (df.get(Boolean.TRUE).size() < minIngredians) {
            return false;
        }

        if (df.get(Boolean.FALSE).size() < minIngredians) {
            return false;
        }

        return true;
    }

    private void addUpper(List<Cell> cells, Cell cell, int takeUp) {
        if (takeUp == 0) {
            return;
        }

        Cell up = getUp(cell);
        cells.add(up);

        addUpper(cells, up, takeUp - 1);
    }

    private Cell getUp(Cell cell) {
        return cellsArr[cell.getRow() - 1][cell.getCol()];
    }

    private Cell getDown(Cell cell) {
        return cellsArr[cell.getRow() + 1][cell.getCol()];
    }

    public Comparator<Cell> reverseCellComparator
            = (cell1, cell2) -> {

                int a = cell1.getRow() - cell2.getRow();
                if (a == 0) {
                    return cell1.getColumn() - cell2.getColumn();
                }
                return a;

            };

    public int getMinIngredians() {
        return minIngredians;
    }

    public void setMinIngredians(int minIngredians) {
        this.minIngredians = minIngredians;
    }

    public int getMaxSliceSize() {
        return maxSliceSize;
    }

    public void setMaxSliceSize(int maxSliceSize) {
        this.maxSliceSize = maxSliceSize;
    }

    public TreeSet<Cell> getCellsSet() {
        return cellsSet;
    }
}
