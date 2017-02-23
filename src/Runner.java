import in.InputDataReader;
import model.InputData;
import model.Solution;
import out.FileResultsPrinter;
import solution.ProblemSolver;

public class Runner {

    public static void main(String[] args) {
        InputData inputData = new InputDataReader().readData("test.txt");
        Solution solution = new ProblemSolver().getSolution(inputData);
        new FileResultsPrinter().printResults(solution, "results.txt");
    }
}
