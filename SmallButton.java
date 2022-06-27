import javax.swing.*;
import java.awt.*;

public class SmallButton extends JButton {
    public SmallButton(String string) {
        setupButton(string);
    }

    private void setupButton(String string) {
        setSize(75, 50);
        setText(string);
        setFont(new Font("Tahoma", Font.BOLD, 18));
    }
}
