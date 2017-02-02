package model;


public class Cell implements Comparable<Cell> {

    private int row;
    private int col;

    private boolean isTomato;

    private boolean isIncluded;

    private Cell right;
    private Cell down;

    public Cell(boolean isTomato) {
        this.isTomato = isTomato;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean isIncluded) {
        this.isIncluded = isIncluded;
    }

    public boolean isTomato() {
        return isTomato;
    }

    public void setTomato(boolean tomato) {
        isTomato = tomato;
    }

    public int getCol() {
        return col;
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

    @Override
    public String toString() {
        return row + " " + col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return col;
    }

    public void setColumn(int column) {
        this.col = column;
    }

    @Override
    public int compareTo(Cell o) {
        int a = this.col - o.getColumn();
        if (a == 0) {
            return this.row - o.getRow();
        }
        return a;
    }
}
