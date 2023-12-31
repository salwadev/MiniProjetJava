import javax.swing.*;
import view.FirstInterface;

public class MainFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        FirstInterface firstinterfaceView = new FirstInterface();

        JFrame frame = firstinterfaceView.getFrame();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
