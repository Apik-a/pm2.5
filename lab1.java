import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lab1 extends JFrame {
    private JFrame mainFrame;

    public lab1(JFrame mainFrame) {
        this.mainFrame = mainFrame;

        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PM2.5");

        JPanel panel = new JPanel(new GridLayout(10, 20, 5, 5));
        panel.setBackground(new Color(255, 242, 215));

        for (int i = 0; i < 200; i++) {
            JPanel box = new JPanel();
            box.setBackground(new Color(248, 199, 148));
            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    calculateAndShowResult(box);
                }
            });

            panel.add(box);
        }

        add(panel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
            }
        });
    }

    private void calculateAndShowResult(JPanel box) {
        List<Integer> numbers = readNumbersFromFile("C:\\Users\\apikm\\Downloads\\pm2.5.txt");

        if (numbers != null && !numbers.isEmpty()) {
            // Randomly select a number from the list
            Random random = new Random();
            int randomIndex = random.nextInt(numbers.size());
            int selectedNumber = numbers.get(randomIndex);

            // Perform your calculation with the selected number
            int result = selectedNumber * 2; // Example: multiply the selected number by 2

            box.removeAll();

            JLabel label = new JLabel("N: " + selectedNumber, SwingConstants.CENTER);
            JLabel label2 = new JLabel("R: "+ result, SwingConstants.SOUTH);
            box.add(label, BorderLayout.CENTER);
            box.add(label2, BorderLayout.SOUTH);

            box.revalidate();
            box.repaint();
        } else {
            box.removeAll();
            JLabel label = new JLabel("No Data", SwingConstants.CENTER);
            box.add(label, BorderLayout.CENTER);
            box.revalidate();
            box.repaint();
        }
    }

    private List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Split the line by spaces (or other delimiter if necessary)
                    String[] parts = line.trim().split("\\s+");
                    for (String part : parts) {
                        numberList.add(Integer.parseInt(part.trim()));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberList;
    }
}