import javax.swing.*;

public class lab16 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(20, 20, 100, 25);
        
        JTextField nameField = new JTextField();
        nameField.setBounds(130, 20, 200, 25);
        
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 100, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 60, 200, 25);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 100, 100, 25);

        JTextArea addressArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(addressArea); 
        scrollPane.setBounds(130, 100, 200, 80);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(150, 200, 100, 30);

        submitBtn.addActionListener(e -> {
            String username = nameField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            String address = addressArea.getText().trim();

            if (username.isEmpty() || password.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(addressLabel);
        panel.add(scrollPane);
        panel.add(submitBtn);

        frame.add(panel);

        frame.setVisible(true);
    }
}
