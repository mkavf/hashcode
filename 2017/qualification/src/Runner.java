import in.InputDataReader;
import model.InputData;
import model.Solution;
import out.FileResultsPrinter;
import solution.ProblemSolver;

public class Runner {

    public static void main(String[] args) {
        InputData inputData = new InputDataReader().readData("me_at_the_zoo.in");
        Solution solution = new ProblemSolver().getSolution(inputData);
        new FileResultsPrinter().printResults(solution, "results.txt");
    }
}
