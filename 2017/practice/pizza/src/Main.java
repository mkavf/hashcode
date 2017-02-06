import model.Pizza;
import model.Solution;
import out.FileResultDisplay;
import out.FrameResultsDisplay;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Pizza inputData = new FileScannerReader().read("d:\\work\\@hashcode\\hashcode\\2017\\practice\\pizza\\bfile.txt");
        Solution solution1 = getSolution(new OneWayPizzaBruteForceSolver(), inputData);
//        Solution solution2 = getSolution(new TwoWayPizzaBruteForceSolver(), inputData);
        int pizzaArea = inputData.getColls() * inputData.getRows();
        System.out.println("Pizza area: " + pizzaArea);
        new FileResultDisplay().display(inputData, solution1);
        if (pizzaArea < 60000) {
            System.out.println("Slices area: " + solution1.getSlices());
            new FrameResultsDisplay().display(inputData, solution1);
        }
        System.out.println(inputData);
    }

    private static Solution getSolution(PizzaSolver pizzaSolver, Pizza inputData) {
        Solution solution1 = pizzaSolver.getSolution(inputData);
        System.out.println(pizzaSolver.getClass().getSimpleName() + " slices count: " + solution1.getSlices().size());
        System.out.println(pizzaSolver.getClass().getSimpleName() + " slices area: " + solution1.slicesArea());
        return solution1;
    }
}
