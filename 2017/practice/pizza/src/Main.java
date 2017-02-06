import model.Pizza;
import model.Solution;
import out.FrameResultsDisplay;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Pizza inputData = new FileScannerReader().read("d:\\marta\\hashcode\\@hashcode\\2017\\practice\\pizza\\bfile.txt");
        Solution solution1 = new OneWayPizzaBruteForceSolver().getSolution(inputData);
        Solution solution2 = new TwoWayPizzaBruteForceSolver().getSolution(inputData);
        System.out.println("Slices count: 1-way = " + solution1.getSlices().size() + "; 2-way= " + solution2.getSlices().size());
        System.out.println("Slices area: 1-way = "+ solution1.slicesArea() + "; 2-way= " +  solution2.slicesArea());
        int pizzaArea = inputData.getColls() * inputData.getRows();
        System.out.println("Pizz area: " + pizzaArea);
        if (pizzaArea < 1000) {
            System.out.println("Slices area: " + solution2.getSlices());
            new FrameResultsDisplay().display(inputData, solution2);
        }
        System.out.println(inputData);
    }
}
