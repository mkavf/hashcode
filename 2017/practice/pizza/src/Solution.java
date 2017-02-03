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
}
