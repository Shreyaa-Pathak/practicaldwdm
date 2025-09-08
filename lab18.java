import javax.swing.*;

public class lab18 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(exit);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        editMenu.add(cut);
        editMenu.add(copy);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        frame.setJMenuBar(menuBar);

        // Enable/Disable programmatically
        open.setEnabled(true);   // enabled
        save.setEnabled(false);  // disabled

        // Exit action
        exit.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
