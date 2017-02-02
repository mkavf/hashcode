package model;

import java.util.Arrays;

public class InputData {
    private Cell[][] pizza;
    private int minElements;
    private int maxSize;

    public Cell[][] getPizza() {
        return pizza;
    }

    public void setPizza(Cell[][] pizza) {
        this.pizza = pizza;
    }

    public int getMinElements() {
        return minElements;
    }

    public void setMinElements(int minElements) {
        this.minElements = minElements;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "pizza=" + Arrays.toString(pizza) +
                ", minElements=" + minElements +
                ", maxSize=" + maxSize +
                '}';
    }
}
