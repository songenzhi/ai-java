package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.concurrent.ExecutionException;

public class SimpleCalculator extends JFrame {

    private JTextField numField1;
    private JTextField numField2;
    private JLabel imageLabel;
    private JLabel2 resultLabel;

    public SimpleCalculator() {
        setTitle("Colorful Calculator");
        setSize(400, 380); // Increased height for image and text
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with a color
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Image Panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        imageLabel = new JLabel("Loading image...", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(128, 128));
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.setBackground(new Color(240, 248, 255));
        
        loadAndSetImage();

        // Central panel for inputs and buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 10));
        centerPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 5, 5));
        inputPanel.setBackground(new Color(230, 230, 250)); // Lavender
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Numbers"));
        inputPanel.add(new JLabel("Number 1:"));
        numField1 = new JTextField();
        inputPanel.add(numField1);
        inputPanel.add(new JLabel("Number 2:"));
        numField2 = new JTextField();
        inputPanel.add(numField2);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        
        JButton addButton = createOperatorButton("+", new Color(70, 130, 180)); // Steel Blue
        JButton subtractButton = createOperatorButton("-", new Color(220, 20, 60)); // Crimson
        JButton multiplyButton = createOperatorButton("*", new Color(60, 179, 113)); // Medium Sea Green
        JButton divideButton = createOperatorButton("/", new Color(255, 140, 0)); // Dark Orange
        
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Add panels to the center panel
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add panels to the main frame
        mainPanel.add(imagePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Action listener
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(numField1.getText());
                    double num2 = Double.parseDouble(numField2.getText());
                    String message;

                    String operator = ((JButton) e.getSource()).getText();
                    switch (operator) {
                        case "+":
                            message = String.format("Result: %.2f", num1 + num2);
                            break;
                        case "-":
                             message = String.format("Result: %.2f", num1 - num2);
                            break;
                        case "*":
                             message = String.format("Result: %.2f", num1 * num2);
                            break;
                        case "/":
                            if (num2 == 0) {
                                message = "Cannot divide by zero";
                            } else {
                                message = String.format("Result: %.2f", num1 / num2);
                            }
                            break;
                        default:
                             message = "Unknown operation";
                    }
                    JOptionPane.showMessageDialog(SimpleCalculator.this, message, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SimpleCalculator.this, "Invalid input. Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }
    
    private void loadAndSetImage() {
        // Use SwingWorker to load image in the background
        new SwingWorker<ImageIcon, Void>() {
            @Override
            protected ImageIcon doInBackground() throws Exception {
                // This new URL is less likely to be blocked and is a direct image link.
                URL imageUrl = new URL("https://img.icons8.com/plasticine/100/calculator.png");
                Image image = ImageIO.read(imageUrl);
                return new ImageIcon(image);
            }

            @Override
            protected void done() {
                try {
                    ImageIcon imageIcon = get();
                    if (imageIcon.getImage() != null) {
                        imageLabel.setText(null); // Remove "Loading..." text
                        imageLabel.setIcon(imageIcon);
                    } else {
                         throw new Exception("Image loaded but it's null.");
                    }
                } catch (Exception e) {
                    imageLabel.setText("Image failed to load.");
                    // Show a more user-friendly error message
                    JOptionPane.showMessageDialog(
                        SimpleCalculator.this,
                        "Could not load the calculator image from the web.\n" +
                        "Please check your internet connection and firewall settings.",
                        "Image Loading Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }.execute();
    }
    
    private JButton createOperatorButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(60, 40));
        return button;
    }

    public static void main(String[] args) {
        // Ensure UI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator().setVisible(true);
            }
        });
    }
}
