import model.Cell;

import java.util.Collection;
import java.util.TreeSet;

public class Slice {

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

    public String getCoordinates(){
        return cells.first().toString()+" "+cells.last().toString();
    }
}
