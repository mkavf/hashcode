package model;


public class Cell {

    private CellType type;

    private boolean isIncluded;


    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIsIncluded(boolean isIncluded) {
        this.isIncluded = isIncluded;
    }

    public enum CellType {
        TOMATO, MUSHROOM
    }
}
