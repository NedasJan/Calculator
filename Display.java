import javax.swing.*;
import java.awt.*;

public class Display extends JTextField {
    public Display() {
        setupDisplay();
    }

    private void setupDisplay() {
        setBounds(10, 10, 330, 75);
        setEditable(false);
        setFont(new Font("Tahoma", Font.BOLD, 36));
        setHorizontalAlignment(RIGHT);
    }

}
