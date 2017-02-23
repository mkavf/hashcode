import in.InputDataReader;
import model.InputData;
import model.Solution;
import out.FileResultsPrinter;
import solution.ProblemSolver;

public class Runner {

    public static void main(String[] args) {
        InputData inputData = new InputDataReader().readData("D:\\Projects\\hashcode\\2017\\qualification\\videos_worth_spreading.in");
        Solution solution = new ProblemSolver().getSolution(inputData);
        new FileResultsPrinter().printResults(solution, "videos_worth_spreading.out");
    }
}
