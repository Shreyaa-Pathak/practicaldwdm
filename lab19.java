import javax.swing.*;
import java.awt.*;

public class lab19 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); // panel whose background will change
        JButton btn = new JButton("Choose Color");

        btn.addActionListener(e -> {
            Color color = JColorChooser.showDialog(frame, "Pick a Color", panel.getBackground());
            if (color != null) {
                panel.setBackground(color);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(btn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
