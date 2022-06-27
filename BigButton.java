import javax.swing.*;
import java.awt.*;

public class BigButton extends JButton {
    public BigButton(String string) {
        setupButton(string);
    }

    private void setupButton(String string) {
        setSize(160, 50);
        setText(string);
        setFont(new Font("Tahoma", Font.BOLD, 18));
    }
}
