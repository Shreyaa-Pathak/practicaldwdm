import javax.swing.*;
import java.awt.*;

public class lab15 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();

        JButton b1 = new JButton("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(b1, gbc);

        JButton b2 = new JButton("Button 2");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(b2, gbc);

        JButton b3 = new JButton("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(b3, gbc);

        JButton b4 = new JButton("Button 4");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(b4, gbc);

        JButton b5 = new JButton("Button 5");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(b5, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
