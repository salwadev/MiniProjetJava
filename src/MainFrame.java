
import javax.swing.*;
import controller.EnseignantController;
import view.EnseignantView;

public class MainFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        EnseignantView enseignantView = new EnseignantView();
        EnseignantController enseignantController = new EnseignantController(enseignantView);

        JFrame frame = enseignantView.getFrame();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}