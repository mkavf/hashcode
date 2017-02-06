import model.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaSmartBruteForceSolver {

    private int minIngredians = 0;
    private int maxSliceSize = 0;

    private int rows;
    private int colls;

    private TreeSet<Cell> cellsSet = new TreeSet<>();


    private List<Slice> slices = new ArrayList<>();
    private Solution bestSolution = null;

    private Cell[][] cellsArr = null;

    private int maxSlicesCount;
    private int bestSlicesCount;
    private int smallPeaceEnough;

    private TreeSet<Solution> nextSolutions = new TreeSet<>((s1, s2) -> {
        return Integer.compare(s2.slicesArea(), s1.slicesArea());
    });

    public Solution getSolution(Pizza pizza) {
        init(pizza);

        Solution solution = new Solution(rows, colls, new byte[rows * colls], new ArrayList<>(maxSlicesCount));
        do {
            solution = prepareSolution(solution);
            if (isPerfectSolution(solution)) {
                return solution;
            }
            if (isBetterThanBest(solution)) {
                bestSolution = solution;
            }

            solution = nextSolutions.pollFirst();
        } while (Objects.nonNull(solution));
        return bestSolution;
    }

    private boolean isBetterThanBest(Solution solution) {
        return Objects.isNull(bestSolution) || solution.slicesArea() > bestSolution.slicesArea();
    }

    private boolean isPerfectSolution(Solution solution) {
        return solution.getSlices().size() == bestSlicesCount && solution.slicesArea() == rows * colls;
    }

    private Solution prepareSolution(Solution solution) {

        int nextAvailableCellIndex;
        while ((nextAvailableCellIndex = solution.getNextAvailableCell()) >= 0) {
            Cell nextAvailable = cellsArr[nextAvailableCellIndex / colls][nextAvailableCellIndex % colls];
            LinkedList<Slice> slices = getPossibleSlicesStartingAt(solution, nextAvailable);
            Slice firstSlice = slices.pollFirst();
            while (createMoreSolutions(solution) && !slices.isEmpty()) {
                Solution newSol = solution.clone();
                newSol.addSlice(slices.pollFirst());
                nextSolutions.add(newSol);
            }
            if (firstSlice != null) {
                solution.addSlice(firstSlice);
            }
            solution.changeReverse();
        }
        return solution;
    }

    private boolean createMoreSolutions(Solution solution) {
        return solution.getFreeCellsCount() < smallPeaceEnough;
    }

    private LinkedList<Slice> getPossibleSlicesStartingAt(Solution solution, Cell start) {
        LinkedList<Slice> slices = new LinkedList<>();
        for (int width = maxSliceSize; width > 0; width--) {
            for (int height = maxSliceSize; height > 0; height--) {
                Cell tempCell = start;
                if (solution.isReverse()) {
                    int startCol = solution.isReverse() ? start.getCol() - width + 1 : start.getCol();
                    int startRow = solution.isReverse() ? start.getRow() - height + 1 : start.getRow();
                    if (startCol <0 || startRow<0 ){
                        continue;
                    }
                    tempCell = cellsArr[startRow][startCol];
                }
                if (isValidBounds(solution, tempCell, width, height) && hasValidIngredients(tempCell, width, height)) {
                    slices.add(createSliceAt(tempCell, width, height));
                }
            }
        }
        return slices;
    }

    private boolean isValidBounds(Solution solution, Cell start, int width, int height) {
        if (width * height > maxSliceSize || start.getCol() + width > colls || start.getRow() + height > rows) {
            return false;
        }

        for (int i = start.getCol(); i < start.getCol() + width; i++) {
            for (int j = start.getRow(); j < start.getRow() + height; j++) {
                if (!solution.isAvailableCell(cellsArr[j][i].getIndex())) {
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
                if (cellsArr[j][i].isTomato()) {
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
                sliceCells.add(cellsArr[j][i]);
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
        smallPeaceEnough = maxSliceSize * maxSliceSize * 4;

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
