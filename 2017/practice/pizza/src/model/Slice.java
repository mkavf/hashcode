package model;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class Slice implements Comparable<Slice>{

    private final TreeSet<Cell> cells;

    public Slice(Collection<Cell> cells) {
        this.cells = new TreeSet<>((Cell c1, Cell c2) -> {
            int rowsCompare = Integer.compare(c1.getRow(), c2.getRow());
            if (rowsCompare == 0){
                return Integer.compare(c1.getCol(), c2.getCol());
            }
            return rowsCompare;
        });

        this.cells.addAll(cells);
    }

    public String getCoordinatesString(){
        return cells.first().toString()+" "+cells.last().toString();
    }

    public void setNextSlices(List<Slice> nextSolution) {

    }

    public TreeSet<Cell> getCells() {
        return cells;
    }

    @Override
    public int compareTo(Slice o) {
        return Integer.compare(o.getCells().size(), this.getCells().size());
    }

    @Override
    public String toString() {
        return "model.Slice{" +
                 cells +
                '}';
    }
}
