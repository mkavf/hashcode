package model;


import java.util.Objects;

public class Cell implements Comparable<Cell> {

    private int row;
    private int col;

    private boolean isTomato;

    private boolean isIncluded;

    private Cell right;
    private Cell left;

    private Cell down;
    private Cell up;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public Cell getLeft() {
        return left;
    }

    public void setLeft(Cell left) {
        this.left = left;
    }

    public Cell getUp() {
        return up;
    }

    public void setUp(Cell up) {
        this.up = up;
    }

    public void setDown(Cell down) {
        this.down = down;
    }

    public void setRight(Cell right) {
        this.right = right;
    }
}
