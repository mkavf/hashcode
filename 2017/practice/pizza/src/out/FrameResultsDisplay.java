package out;

import model.Cell;
import model.Pizza;
import model.Slice;
import model.Solution;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static javax.swing.JFrame.*;

/**
 * Created by admin on 02.02.2017.
 */
public class FrameResultsDisplay implements ResultsDisplay {

    public static final int GAP = 3;
    Random rand = new Random();

    @Override
    public void display(Pizza pizza, Solution solution) {
        JFrame pizzaFrame = new JFrame("model.Pizza");
        int rows = solution.getRows();
        int colls = solution.getColls();
        pizzaFrame.setMinimumSize(new Dimension(30 * rows, 30 * colls));
        pizzaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridLayout(rows, colls));
        mainPanel.setAutoscrolls(true);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        JPanel[][] panels = new JPanel[rows][colls];
        java.util.List<Slice> slices = solution.getSlices();
        for (Slice slice : slices) {
            Color tomatoColor = getRandomColor();
//            Color mashroomColor = tomatoColor.brighter();
            for (Cell cell : slice.getCells()) {
                panels[cell.getRow()][cell.getCol()] = cell.isTomato()
                        ? createPanel(tomatoColor, "T")
                        : createPanel(tomatoColor, "M");
            }
        }
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < colls; j++) {
                JPanel panel = panels[i][j];
                if (panel == null){
                    String text =  pizza.getCellsArr()[i][j].isTomato() ? "T": "M";
                    panel = createPanel(Color.white, text);
                }
                mainPanel.add(panel);
            }
        }
        pizzaFrame.add(mainPanel);
        pizzaFrame.setVisible(true);

    }

    private JPanel createPanel(Color color, String text) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        panel.add(new JLabel(text));
        panel.setMinimumSize(new Dimension(30,30));
        return panel;
    }


    public Color getRandomColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }
}
