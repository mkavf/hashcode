package out;

import model.Pizza;
import model.Solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileResultDisplay implements ResultsDisplay {
    @Override
    public void display(Pizza pizza, Solution solution) {
        String filePath = "out_"+pizza.getRows()+"x"+pizza.getColls()+".txt";
        deleteIfExists(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(solution.getSlices().size()));
            writer.write('\n');
            solution.getSlices().forEach(s -> {
                try {
                    writer.write(s.getCoordinatesString());
                    writer.write('\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteIfExists(String filePath) {
        try {
            Path output = Paths.get(filePath);
            Files.deleteIfExists(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
