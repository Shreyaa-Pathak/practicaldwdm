import javax.swing.*;

public class lab17 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Favorite Programming Languages");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JLabel languageLabel = new JLabel("Select your favorite programming languages:");
        JCheckBox javaBox = new JCheckBox("Java");
        JCheckBox pythonBox = new JCheckBox("Python");
        JCheckBox cppBox = new JCheckBox("C++");

        JLabel levelLabel = new JLabel("Select your proficiency level:");
        JRadioButton beginner = new JRadioButton("Beginner");
        JRadioButton advanced = new JRadioButton("Advanced");
        ButtonGroup levelGroup = new ButtonGroup();
        levelGroup.add(beginner);
        levelGroup.add(advanced);

        JLabel resultLabel = new JLabel("Your selection will appear here");

        JButton showBtn = new JButton("Show Selection");

        showBtn.addActionListener(e -> {
            StringBuilder result = new StringBuilder("You selected: Languages: ");

            if (javaBox.isSelected()) result.append("Java ");
            if (pythonBox.isSelected()) result.append("Python ");
            if (cppBox.isSelected()) result.append("C++ ");

            result.append("| Level: ");
            if (beginner.isSelected()) result.append("Beginner");
            else if (advanced.isSelected()) result.append("Advanced");
            else result.append("None");

            resultLabel.setText(result.toString());
        });

        panel.add(languageLabel);
        panel.add(javaBox);
        panel.add(pythonBox);
        panel.add(cppBox);

        panel.add(levelLabel);
        panel.add(beginner);
        panel.add(advanced);

        panel.add(showBtn);
        panel.add(resultLabel);

        frame.setVisible(true);
    }
}
