package model;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private byte[] occupiedCells;
    private List<Slice> slices;
    private int nextAvailableCell = 0;
    private int lastAvailableCell = 0;
    private int freeCellsCount;
    private boolean reverse;
    private int rows;
    private int colls;
    private int lastReservedRow;
    private int lastReservedCol;

    public Solution(int rows, int colls, byte[] occupiedCells, List<Slice> slices) {
        this.rows = rows;
        this.colls = colls;
        this.occupiedCells = occupiedCells;
        this.slices = slices;
        freeCellsCount = getFreeCellsCount(occupiedCells);
        lastAvailableCell = occupiedCells.length-1;
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
        if (reverse){
            return getLastAvailableCell();
        }
        if (nextAvailableCell > lastAvailableCell){
            return -1;
        }
        while (occupiedCells[nextAvailableCell] != 0){
            nextAvailableCell++;
            if (nextAvailableCell > lastAvailableCell){
                return -1;
            }
        }
        return nextAvailableCell++;
    }

    public int getLastAvailableCell() {
        if (lastAvailableCell < nextAvailableCell){
            return -1;
        }
        while (occupiedCells[lastAvailableCell] != 0){
            lastAvailableCell--;
            if (lastAvailableCell < nextAvailableCell){
                return -1;
            }
        }
        return lastAvailableCell--;
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
        reverse = !reverse;
    }

    public int getRows() {
        return rows;
    }

    public int getColls() {
        return colls;
    }
}
