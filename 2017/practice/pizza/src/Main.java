import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Pizza inputData = new FileScannerReader().read("d:\\marta\\hashcode\\@hashcode\\2017\\practice\\pizza\\file.txt");
        Solution solution = new PizzaBruteForceSolver().getSolution(inputData);
        System.out.println("Slices count: " + solution.getSlices().size());
        System.out.println("Slices area: " + solution.slicesArea());
        System.out.println("Pizz area: " + inputData.getColls()*inputData.getRows());
        System.out.println(inputData);
    }
}
