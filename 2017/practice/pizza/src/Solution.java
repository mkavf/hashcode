import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private byte[] occupiedCells;
    private List<Slice> slices;
    private int nextCell = 0;

    public Solution(byte[] occupiedCells, List<Slice> slices) {
        this.occupiedCells = occupiedCells;
        this.slices = slices;
    }

    @Override
    public Solution clone() {
        return new Solution(this.occupiedCells.clone(), new ArrayList<>(this.slices));
    }

    public int getNextAvailableCell(){
        if (nextCell >= occupiedCells.length){
            return -1;
        }
        while (occupiedCells[nextCell] != 0){
            nextCell++;
        }
        return nextCell++;
    }

    public void addSlice(Slice slice) {
        slices.add(slice);
        for (Cell cell: slice.getCells()){
            occupiedCells[cell.getIndex()]=1;
        }
    }
}
