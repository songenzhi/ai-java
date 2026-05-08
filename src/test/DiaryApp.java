package test;

import javax.swing.SwingUtilities;

public class DiaryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiaryUI().setVisible(true));
    }
}
