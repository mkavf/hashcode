package model;


public class Cell {

    private int row;
    private int col;

    private boolean isTomato;

    private boolean isIncluded;

    public Cell(boolean isTomato) {
        this.isTomato = isTomato;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean isIncluded) {
        this.isIncluded = isIncluded;
    }


    public Cell getRigth() {

    }

    public Cell getDown() {

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

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return row + " " + col;
    }
}
