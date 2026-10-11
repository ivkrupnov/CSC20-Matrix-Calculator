package arrayops;

import javax.swing.*;
import java.awt.*;

public class MatrixGUI extends JFrame {

    // Numerical Matrix components
    private JTextArea matrixA;
    private JTextArea matrixB;
    private JTextArea resultArea;
    private JComboBox<String> operations;

    // String Matrix components
    private JTextArea stringA;
    private JTextArea stringB;
    private JTextArea stringResultArea;

    // Word Library components
    private JTextArea libraryArea;

    // Constructor
    public MatrixGUI() {

        setTitle("Matrix Calculator");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create tabs
        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Numerical Matrix", createNumericalPanel());
        tabs.addTab("String Matrix", createStringPanel());
        tabs.addTab("Word Library", createLibraryPanel());

        add(tabs);

        setVisible(true);
    }


    // ==========================================
    // NUMERICAL MATRIX TAB
    // ==========================================

    private JPanel createNumericalPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input areas
        matrixA = new JTextArea("-1 0 5\n3 2 7\n1 0 1");
        matrixB = new JTextArea("0 1 0\n0 1 0\n0 1 0");

        matrixA.setFont(new Font("Monospaced", Font.PLAIN, 16));
        matrixB.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JScrollPane scrollA = new JScrollPane(matrixA);
        JScrollPane scrollB = new JScrollPane(matrixB);

        scrollA.setBorder(
            BorderFactory.createTitledBorder("Matrix A")
        );

        scrollB.setBorder(
            BorderFactory.createTitledBorder("Matrix B")
        );

        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        inputPanel.add(scrollA);
        inputPanel.add(scrollB);

        panel.add(inputPanel, BorderLayout.CENTER);

        // Operations
        String[] choices = {
            "Addition",
            "Subtraction",
            "Element-wise Multiplication",
            "Matrix Multiplication"
        };

        operations = new JComboBox<>(choices);

        JButton calculateButton = new JButton("Calculate");

        JPanel controlPanel = new JPanel();

        controlPanel.add(new JLabel("Operation:"));
        controlPanel.add(operations);
        controlPanel.add(calculateButton);

        // Result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JScrollPane resultScroll = new JScrollPane(resultArea);

        resultScroll.setPreferredSize(new Dimension(600, 140));

        resultScroll.setBorder(
            BorderFactory.createTitledBorder("Result")
        );

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));

        bottomPanel.add(controlPanel, BorderLayout.NORTH);
        bottomPanel.add(resultScroll, BorderLayout.CENTER);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Calculate button
        calculateButton.addActionListener(e -> calculateNumerical());

        return panel;
    }


    // ==========================================
    // STRING MATRIX TAB
    // ==========================================

    private JPanel createStringPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // String input areas
        stringA = new JTextArea(
            "Bicycle Sand Iron\nHorse Human Flour\nSun Clay Wood"
        );

        stringB = new JTextArea(
            "Engine Heat Carbon\nWings Machine Water\nRain Fire Wheels"
        );

        stringA.setFont(new Font("Monospaced", Font.PLAIN, 16));
        stringB.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JScrollPane scrollA = new JScrollPane(stringA);
        JScrollPane scrollB = new JScrollPane(stringB);

        scrollA.setBorder(
            BorderFactory.createTitledBorder("String Matrix A")
        );

        scrollB.setBorder(
            BorderFactory.createTitledBorder("String Matrix B")
        );

        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        inputPanel.add(scrollA);
        inputPanel.add(scrollB);

        panel.add(inputPanel, BorderLayout.CENTER);

        // Combine button
        JButton combineButton = new JButton("Combine Words");

        JPanel controlPanel = new JPanel();
        controlPanel.add(combineButton);

        // Result area
        stringResultArea = new JTextArea();
        stringResultArea.setEditable(false);
        stringResultArea.setFont(
            new Font("Monospaced", Font.PLAIN, 16)
        );

        JScrollPane resultScroll = new JScrollPane(stringResultArea);

        resultScroll.setPreferredSize(new Dimension(600, 140));

        resultScroll.setBorder(
            BorderFactory.createTitledBorder("Combined String Matrix")
        );

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));

        bottomPanel.add(controlPanel, BorderLayout.NORTH);
        bottomPanel.add(resultScroll, BorderLayout.CENTER);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Combine button action
        combineButton.addActionListener(e -> calculateStrings());

        return panel;
    }


    // ==========================================
    // WORD LIBRARY TAB
    // ==========================================

    private JPanel createLibraryPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input fields
        JTextField firstWord = new JTextField();
        JTextField secondWord = new JTextField();
        JTextField resultWord = new JTextField();

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("First Word:"));
        inputPanel.add(firstWord);

        inputPanel.add(new JLabel("Second Word:"));
        inputPanel.add(secondWord);

        inputPanel.add(new JLabel("Result:"));
        inputPanel.add(resultWord);

        // Add combination button
        JButton addButton = new JButton("Add Combination");

        inputPanel.add(addButton);
        inputPanel.add(new JLabel(""));

        panel.add(inputPanel, BorderLayout.NORTH);

        // Library display
        libraryArea = new JTextArea();

        libraryArea.setEditable(false);
        libraryArea.setFont(
            new Font("Monospaced", Font.PLAIN, 14)
        );

        // Display existing combinations
        libraryArea.setText(WordLibrary.getAllCombinations());

        JScrollPane scrollPane = new JScrollPane(libraryArea);

        scrollPane.setBorder(
            BorderFactory.createTitledBorder("Available Combinations")
        );

        panel.add(scrollPane, BorderLayout.CENTER);

        // Add combination button action
        addButton.addActionListener(e -> {

            String first = firstWord.getText().trim();
            String second = secondWord.getText().trim();
            String result = resultWord.getText().trim();

            try {

                // Add the combination to WordLibrary
                WordLibrary.addCombination(first, second, result);

                // Refresh the displayed library
                libraryArea.setText(
                    WordLibrary.getAllCombinations()
                );

                // Clear input fields
                firstWord.setText("");
                secondWord.setText("");
                resultWord.setText("");

                JOptionPane.showMessageDialog(
                    this,
                    "Combination added successfully!"
                );

            } catch (IllegalArgumentException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        return panel;
    }


    // ==========================================
    // NUMERICAL CALCULATIONS
    // ==========================================

    private void calculateNumerical() {

        resultArea.setText("");

        try {

            int[][] array1 = parseNumericalMatrix(matrixA.getText());
            int[][] array2 = parseNumericalMatrix(matrixB.getText());

            NumericalMatrix a = new NumericalMatrix(array1);
            NumericalMatrix b = new NumericalMatrix(array2);

            NumericalMatrix result = null;

            int selected = operations.getSelectedIndex();

            switch (selected) {

                case 0:
                    result = a.add(b);
                    break;

                case 1:
                    result = a.subtract(b);
                    break;

                case 2:
                    result = a.multiplyWise(b);
                    break;

                case 3:
                    result = a.multiply(b);
                    break;
            }

            // Check incompatible dimensions
            if (result == null) {

                String message;

                if (selected == 3) {
                    message = "Columns of A must equal rows of B.";
                } else {
                    message = "Matrices must have the same dimensions.";
                }

                JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Matrix Error",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            resultArea.setText(result.toString());

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ==========================================
    // STRING MATRIX CALCULATIONS
    // ==========================================

    private void calculateStrings() {

        stringResultArea.setText("");

        try {

            String[][] array1 = parseStringMatrix(stringA.getText());
            String[][] array2 = parseStringMatrix(stringB.getText());

            StringMatrix a = new StringMatrix(array1);
            StringMatrix b = new StringMatrix(array2);

            // Uses WordLibrary through StringMatrix.add()
            StringMatrix result = a.add(b);

            if (result == null) {

                JOptionPane.showMessageDialog(
                    this,
                    "String matrices must have the same dimensions.",
                    "Matrix Error",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            stringResultArea.setText(result.toString());

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ==========================================
    // PARSE NUMERICAL MATRIX
    // ==========================================

    private int[][] parseNumericalMatrix(String text) {

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Matrix cannot be empty."
            );
        }

        String[] rows = text.trim().split("\\R");

        int[][] result = new int[rows.length][];

        int columnCount = -1;

        for (int i = 0; i < rows.length; i++) {

            String[] values = rows[i].trim().split("[,\\s]+");

            if (columnCount == -1) {
                columnCount = values.length;
            }

            if (values.length != columnCount) {
                throw new IllegalArgumentException(
                    "All rows must have the same number of columns."
                );
            }

            result[i] = new int[values.length];

            for (int j = 0; j < values.length; j++) {

                try {
                    result[i][j] = Integer.parseInt(values[j]);

                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException(
                        "Please enter valid integers."
                    );
                }
            }
        }

        return result;
    }


    // ==========================================
    // PARSE STRING MATRIX
    // ==========================================

    private String[][] parseStringMatrix(String text) {

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "String matrix cannot be empty."
            );
        }

        String[] rows = text.trim().split("\\R");

        String[][] result = new String[rows.length][];

        int columnCount = -1;

        for (int i = 0; i < rows.length; i++) {

            if (rows[i].trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "Matrix rows cannot be empty."
                );
            }

            String[] values = rows[i].trim().split("[,\\s]+");

            if (columnCount == -1) {
                columnCount = values.length;
            }

            if (values.length != columnCount) {
                throw new IllegalArgumentException(
                    "All rows must have the same number of columns."
                );
            }

            result[i] = new String[values.length];

            for (int j = 0; j < values.length; j++) {
                result[i][j] = values[j];
            }
        }

        return result;
    }


    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new MatrixGUI());

    }
}