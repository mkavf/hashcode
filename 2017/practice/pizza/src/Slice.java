import model.Cell;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private boolean isValidSlice(int maxSliceSize, int minElements) {
        if(cells.size() > maxSliceSize){
            return false;
        }

        Map<Boolean, List<Cell>> df = cells.stream().collect(Collectors.groupingBy(Cell::isTomato));

        return df.values().stream().map(l -> l.size() > minElements).filter(t -> t).findAny().orElse(false);

    }
}
