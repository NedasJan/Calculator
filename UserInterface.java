import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JLabel implements ActionListener {
    private JTextField display = new Display();
    private JButton num0Button = new SmallButton("0");
    private JButton num1Button = new SmallButton("1");
    private JButton num2Button = new SmallButton("2");
    private JButton num3Button = new SmallButton("3");
    private JButton num4Button = new SmallButton("4");
    private JButton num5Button = new SmallButton("5");
    private JButton num6Button = new SmallButton("6");
    private JButton num7Button = new SmallButton("7");
    private JButton num8Button = new SmallButton("8");
    private JButton num9Button = new SmallButton("9");
    private JButton dotButton = new SmallButton(".");
    private JButton equalsButton = new SmallButton("=");
    private JButton additionButton = new SmallButton("+");
    private JButton subtractionButton = new SmallButton("-");
    private JButton multiplicationButton = new SmallButton("*");
    private JButton divisionButton = new SmallButton("/");
    private JButton deleteButton = new BigButton("Delete");
    private JButton clearButton = new BigButton("Clear");

    private boolean dotHasBeenUsed = false;
    private ExpressionParser expressionParser = new ExpressionParser();

    public UserInterface() {
        setupUI();
    }

    private void setupUI() {
        setupPanel();
        setupButtonLayout();

        addActionListeners();
        addPanelComponents();
    }

    private void setupPanel() {
        setBounds(0, 0, 365, 510); //Windows;
        //setBounds(0, 0, 350, 500); //Mac OS;

        setBackground(new Color(170, 170, 170));
        setOpaque(true);
    }

    private void addActionListeners() {
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        additionButton.addActionListener(this);
        subtractionButton.addActionListener(this);
        multiplicationButton.addActionListener(this);
        divisionButton.addActionListener(this);
        dotButton.addActionListener(this);
        equalsButton.addActionListener(this);

        num0Button.addActionListener(this);
        num1Button.addActionListener(this);
        num2Button.addActionListener(this);
        num3Button.addActionListener(this);
        num4Button.addActionListener(this);
        num5Button.addActionListener(this);
        num6Button.addActionListener(this);
        num7Button.addActionListener(this);
        num8Button.addActionListener(this);
        num9Button.addActionListener(this);
    }

    private void setupButtonLayout() {
        deleteButton.setLocation(10, 170);
        clearButton.setLocation(180, 170);

        additionButton.setLocation(265, 230);
        subtractionButton.setLocation(265, 290);
        multiplicationButton.setLocation(265, 350);
        divisionButton.setLocation(265, 410);
        dotButton.setLocation(10, 410);
        equalsButton.setLocation(180, 410);

        num0Button.setLocation(95, 410);
        num1Button.setLocation(10, 350);
        num2Button.setLocation(95, 350);
        num3Button.setLocation(180, 350);
        num4Button.setLocation(10, 290);
        num5Button.setLocation(95, 290);
        num6Button.setLocation(180, 290);
        num7Button.setLocation(10, 230);
        num8Button.setLocation(95, 230);
        num9Button.setLocation(180, 230);
    }

    private void addPanelComponents() {
        add(display);

        add(deleteButton);
        add(clearButton);

        add(additionButton);
        add(subtractionButton);
        add(multiplicationButton);
        add(divisionButton);
        add(dotButton);
        add(equalsButton);

        add(num0Button);
        add(num1Button);
        add(num2Button);
        add(num3Button);
        add(num4Button);
        add(num5Button);
        add(num6Button);
        add(num7Button);
        add(num8Button);
        add(num9Button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (deleteButton == source) {
            if(display.getText().length() > 0) {
                display.setText(display.getText().substring(0, display.getText().length() - 1));
            }
        }
        else if (clearButton == source) {
            display.setText("");
        }
        else if (additionButton == source) {
            if(display.getText().length() > 0) {
                char lastChar = display.getText().charAt(display.getText().length() - 1);

                if (lastChar != '.' && lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/') {
                    display.setText(display.getText() + '+');
                    dotHasBeenUsed = false;
                }
            }
        }
        else if (subtractionButton == source) {
            if(display.getText().length() > 0) {
                char lastChar = display.getText().charAt(display.getText().length() - 1);

                if (lastChar != '.' && lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/') {
                    display.setText(display.getText() + '-');
                    dotHasBeenUsed = false;
                }
            }
        }
        else if (multiplicationButton == source) {
            if(display.getText().length() > 0) {
                char lastChar = display.getText().charAt(display.getText().length() - 1);

                if (lastChar != '.' && lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/') {
                    display.setText(display.getText() + '*');
                    dotHasBeenUsed = false;
                }
            }
        }
        else if (divisionButton == source) {
            if(display.getText().length() > 0) {
                char lastChar = display.getText().charAt(display.getText().length() - 1);

                if (lastChar != '.' && lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/') {
                    display.setText(display.getText() + '/');
                    dotHasBeenUsed = false;
                }
            }
        }
        else if (dotButton == source) {
            if(display.getText().length() > 0) {
                if (!dotHasBeenUsed) {
                    char lastChar = display.getText().charAt(display.getText().length() - 1);

                    if (lastChar != '.' && lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/') {
                        display.setText(display.getText() + '.');
                        dotHasBeenUsed = true;
                    }
                }
            }
        }
        else if (equalsButton == source) {
            if(display.getText().length() > 0) {
                dotHasBeenUsed = false;

                if (display.getText().charAt(display.getText().length() - 1) == '.') {
                    display.setText(display.getText() + '0');
                }

                expressionParser.setExpression(display.getText());
                display.setText(expressionParser.getAnswer());
            }
        }
        else if (num0Button == source) {
            display.setText(display.getText() + "0");
        }
        else if (num1Button == source) {
            display.setText(display.getText() + "1");
        }
        else if (num2Button == source) {
            display.setText(display.getText() + "2");
        }
        else if (num3Button == source) {
            display.setText(display.getText() + "3");
        }
        else if (num4Button == source) {
            display.setText(display.getText() + "4");
        }
        else if (num5Button == source) {
            display.setText(display.getText() + "5");
        }
        else if (num6Button == source) {
            display.setText(display.getText() + "6");
        }
        else if (num7Button == source) {
            display.setText(display.getText() + "7");
        }
        else if (num8Button == source) {
            display.setText(display.getText() + "8");
        }
        else if (num9Button == source) {
            display.setText(display.getText() + "9");
        }
    }
}
