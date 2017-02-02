import model.Cell;

import java.util.List;

public class Slice {

    private List<Cell> cells;

    private void add(Cell cell){
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
