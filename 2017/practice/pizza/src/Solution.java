import model.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    private byte[] occupiedCells;
    private List<Slice> slices;
    private int nextCell = 0;
    private int freeCellsCount;
    private boolean reverse;
    private int rows;
    private int colls;

    public Solution(int rows, int colls, byte[] occupiedCells, List<Slice> slices) {
        this.rows = rows;
        this.colls = colls;
        this.occupiedCells = occupiedCells;
        this.slices = slices;
        freeCellsCount = getFreeCellsCount(occupiedCells);
    }

    private int getFreeCellsCount(byte[] occupiedCells) {
        int freeCellsCount = 0;
        for (byte cell:  occupiedCells){
            if (cell == 0){
                freeCellsCount++;
            }
        }
        return freeCellsCount;
    }

    @Override
    public Solution clone() {
        return new Solution(this.rows, this.colls, this.occupiedCells.clone(), new ArrayList<>(this.slices));
    }

    public int getNextAvailableCell(){
        if (nextCell >= occupiedCells.length){
            return -1;
        }
        while (occupiedCells[nextCell] != 0){
            nextCell++;
            if (nextCell >= occupiedCells.length){
                return -1;
            }
        }
        return nextCell++;
    }

    public void addSlice(Slice slice) {
        slices.add(slice);
        for (Cell cell: slice.getCells()){
            occupiedCells[cell.getIndex()]=1;
            freeCellsCount--;
        }
    }

    public List<Slice> getSlices() {
        return slices;
    }

    public int slicesArea() {
        return slices.stream()
                .map(s -> s.getCells().size())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public boolean isAvailableCell(int index) {
        return occupiedCells[index] == 0;
    }

    public int getFreeCellsCount() {
        return freeCellsCount;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void changeReverse() {
//        reverse = !reverse;
    }

    public int getRows() {
        return rows;
    }

    public int getColls() {
        return colls;
    }
}
