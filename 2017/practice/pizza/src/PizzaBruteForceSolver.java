import model.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaBruteForceSolver {

    private int minIngredians = 0;
    private int maxSliceSize = 0;

    private int rows;
    private int colls;

    private TreeSet<Cell> cellsSet = new TreeSet<>();


    private List<Slice> bestSolution = new ArrayList<>();

    private Cell[][] cellsArr = null;

    private List<Slice> validMinSlices = new ArrayList<>();
    private int maxSlicesCount;
    private int bestSlicesCount;

    public List<Slice> getSolution(Pizza pizza) {
        init(pizza);
        Cell start = cellsArr[0][0];
        List<Slice> slices = getNextSolution(start);
        return evaluateBestSolution(slices);
    }

    private List<Slice> evaluateBestSolution(List<Slice> slices) {
        return null;
    }

    private List<Solution> getNextSolution(Solution solution, Cell start) {
        List<Solution> solutions = new ArrayList<>();
        for (Slice slice : getPossibleSlicesStartingAt(start)) {
            Solution newSolution = solution.clone();
            solutions.add(newSolution);
            newSolution.addSlice(slice);

            int nextAvailableCellIndex = solution.getNextAvailableCell();
            if (nextAvailableCellIndex<0){
                return ;
            }

            Cell nextAvailable = cellsArr[nextAvailableCellIndex/colls][nextAvailableCellIndex%colls];
            if (nextAvailable != null) {
                slice.setNextSlices(getNextSolution(newSolution, nextAvailable));
            }
        }
        return solutions;
    }

    private Cell getNextAvailableCellAfter(Solution solution) {

    }

    private List<Slice> getPossibleSlicesStartingAt(Cell start) {
        int maxSliceArea = maxSliceSize;
        List<Slice> slices = new ArrayList<>();
        for (int width = 1; width <= maxSliceArea; width++) {
            int height = maxSliceArea / width;
            if (isValidBounds(start, width, height) && hasValidIngredients(start, width, height)) {
                slices.add(createSliceAt(start, width, height));
            }
        }
        return slices;
    }

    private boolean isValidBounds(Cell start, int width, int height) {
        if (start.getCol() + width > colls || start.getRow() + height > rows) {
            return false;
        }
        for (int i = start.getCol(); i < start.getCol() + width; i++) {
            for (int j = start.getRow(); j < start.getRow() + height; j++) {
                if (cellsArr[i][j].isIncluded()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasValidIngredients(Cell start, int width, int height) {

        int countT = 0;
        int countM = 0;
        for (int i = start.getCol(); i < start.getCol() + width; i++) {
            for (int j = start.getRow(); j < start.getRow() + height; j++) {
                if (cellsArr[i][j].isTomato()) {
                    countT++;
                } else {
                    countM++;
                }
                if (countT >= minIngredians && countM >= minIngredians) {
                    return true;
                }
            }
        }
        return false;
    }

    private Slice createSliceAt(Cell start, int width, int height) {
        List<Cell> sliceCells = new ArrayList<>();
        for (int i = start.getCol(); i < start.getCol() + width; i++) {
            for (int j = start.getRow(); j < start.getRow() + height; j++) {
                sliceCells.add(cellsArr[i][j]);
            }
        }
        return new Slice(sliceCells);
    }

    private void init(Pizza pizza) {
        cellsArr = pizza.getCellsArr();
        cellsSet = pizza.getCellsSet();
        rows = pizza.getRows();
        colls = pizza.getColls();
        minIngredians = pizza.getMinIngredians();
        maxSliceSize = pizza.getMaxSliceSize();


        Map<Boolean, List<Cell>> groupedIngredients = cellsSet.stream().collect(Collectors.groupingBy(Cell::isTomato));
        Iterator<List<Cell>> iterator = groupedIngredients.values().iterator();
        maxSlicesCount = rows * colls / minIngredians / 2;
        bestSlicesCount = rows * colls / maxSliceSize;
        if (rows * colls % maxSliceSize > 0) {
            bestSlicesCount += 1;
        }

        while (iterator.hasNext()) {
            List<Cell> next = iterator.next();
            if (next.size() / minIngredians < maxSlicesCount) {
                maxSlicesCount = next.size() / minIngredians;
            }
        }
        if (bestSlicesCount > maxSlicesCount) {
            bestSlicesCount = maxSlicesCount;
        }
    }

}
