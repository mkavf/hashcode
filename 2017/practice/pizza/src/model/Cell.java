package model;


public class Cell {

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


    public Cell getRigth(){

    }

    public Cell getDown(){

    }

    public boolean isTomato() {
        return isTomato;
    }

    public void setTomato(boolean tomato) {
        isTomato = tomato;
    }
}
