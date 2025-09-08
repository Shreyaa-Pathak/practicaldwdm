import javax.swing.*;

public class lab11 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Form");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);

        // Corrected action listener
        button.addActionListener(e -> {
            String name = textField.getText();
            if (!name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter your name!");
            }
        });

        frame.setVisible(true);
    }
}
