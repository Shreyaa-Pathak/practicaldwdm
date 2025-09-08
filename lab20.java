import javax.swing.*;
import java.awt.event.*;

public class lab20 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click or hover here!", SwingConstants.CENTER);
        frame.add(label);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered!");
            }
        });

        frame.setVisible(true);
    }
}
