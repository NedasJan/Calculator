import javax.swing.*;

public class Calculator extends JFrame {
    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        setupJFrame();
    }

    private void setupJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setSize(350, 500); //Mac OS;
        setSize(365, 510); //Windows;

        setResizable(false);
        setTitle("Calculator");
        setLayout(null);
        setContentPane(new UserInterface());
        setVisible(true);

        //setIconImage(new ImageIcon("icons/CalculatorIcon.png").getImage()); //Mac OS;
        setIconImage(new ImageIcon("icons\\CalculatorIcon.png").getImage()); //Windows;
    }
}
