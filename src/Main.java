import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Sistema de gestión de estudiantes");
        frame.setContentPane(new estudiantes().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }
}