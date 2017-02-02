package model;


public class Cell implements Comparable<Cell> {

    private boolean isTomato;

    private boolean isIncluded;

    private Cell right;
    private Cell down;

    int row;
    int column;

    public Cell(boolean isTomato) {
        this.isTomato = isTomato;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean isIncluded) {
        this.isIncluded = isIncluded;
    }


    public Cell getRigth(){
      return right;
    }

    public Cell getDown(){
       return down;
    }

    public void setRight(Cell right) {
        this.right = right;
    }

    public void setDown(Cell down) {
        this.down = down;
    }

    public boolean isTomato() {
        return isTomato;
    }

    public void setTomato(boolean tomato) {
        isTomato = tomato;
    }

    public void setIsTomato(boolean isTomato) {
        this.isTomato = isTomato;
    }

    public void setIsIncluded(boolean isIncluded) {
        this.isIncluded = isIncluded;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int compareTo(Cell o) {
        int a = this.column - o.getColumn();
        if (a == 0) {
            return this.row - o.getRow();
        }
        return a;
    }
}
