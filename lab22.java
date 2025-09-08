import javax.swing.*;
import java.awt.event.*;

public class lab22 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Select Hobbies");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel hobbiesLabel = new JLabel("Choose your hobbies:");
        
        JCheckBox readingBox = new JCheckBox("Reading");
        JCheckBox travelingBox = new JCheckBox("Traveling");
        JCheckBox musicBox = new JCheckBox("Music");
        
        JLabel resultLabel = new JLabel("Selected hobbies: None");
        
        panel.add(hobbiesLabel);
        panel.add(readingBox);
        panel.add(travelingBox);
        panel.add(musicBox);
        panel.add(resultLabel);
        frame.add(panel);

        ActionListener updateLabel = e -> {
            StringBuilder hobbies = new StringBuilder();
            if (readingBox.isSelected()) hobbies.append("Reading, ");
            if (travelingBox.isSelected()) hobbies.append("Traveling, ");
            if (musicBox.isSelected()) hobbies.append("Music, ");

            if (hobbies.length() > 0) {
                hobbies.setLength(hobbies.length() - 2); // Remove trailing comma and space
                resultLabel.setText("Selected hobbies: " + hobbies);
            } else {
                resultLabel.setText("Selected hobbies: None");
            }
        };

        readingBox.addActionListener(updateLabel);
        travelingBox.addActionListener(updateLabel);
        musicBox.addActionListener(updateLabel);

        frame.setVisible(true);
    }
}
