package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class SecondInterface {
    private JFrame frame;
    private JComboBox<String> classeSearchComboBox;
    private JTextField matiereSearchField;
    private JButton chercherSeanceButton;
    private JTable seanceSearchTable;
    private JTextField idSuppressionField;
    private JButton supprimerSeanceButton;
    private JComboBox<String> classeEmploiComboBox;
    private JButton chercherEmploiButton;
    private JTable emploiTable;

    public SecondInterface() {
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame();
        frame.setTitle("Gestion des Séances de Cours et Emploi du Temps");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        frame.getContentPane().setBackground(Color.PINK);

        JPanel chercherSeancePanel = createChercherSeancePanel();
        JPanel supprimerSeancePanel = createSupprimerSeancePanel();
        JPanel chercherEmploiPanel = createChercherEmploiPanel();
        JPanel emploiPanel = createEmploiPanel();

        frame.add(chercherSeancePanel);
        frame.add(supprimerSeancePanel);
        frame.add(chercherEmploiPanel);
        frame.add(emploiPanel);

        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }
    private JPanel createChercherSeancePanel() {
        JPanel chercherSeancePanel = new JPanel(new BorderLayout());
        chercherSeancePanel.setBorder(BorderFactory.createTitledBorder("Les Séances de Cours dans la Semaine"));
        chercherSeancePanel.setBackground(Color.PINK);

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        formPanel.add(new JLabel("Classe:"));
        classeSearchComboBox = new JComboBox<>(new String[]{"Classe 1", "Classe 2", "Classe 3"});
        formPanel.add(classeSearchComboBox);

        formPanel.add(new JLabel("Matière:"));
        matiereSearchField = new JTextField(10);
        formPanel.add(matiereSearchField);

        chercherSeanceButton = new JButton("CHERCHER");
        chercherSeanceButton.setBackground(Color.GRAY);
        formPanel.add(chercherSeanceButton);

        seanceSearchTable = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Classe", "Jour", "Matière", "Heure", "Enseignant", "Contact Enseignant"}, 0));
        seanceSearchTable.setBackground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(seanceSearchTable);

        chercherSeancePanel.add(formPanel, BorderLayout.NORTH);
        chercherSeancePanel.add(tableScrollPane, BorderLayout.CENTER);

        return chercherSeancePanel;
    }

    private JPanel createSupprimerSeancePanel() {
        JPanel supprimerSeancePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        supprimerSeancePanel.setBorder(BorderFactory.createTitledBorder("Supprimer Séance par ID"));
        supprimerSeancePanel.setBackground(Color.PINK);

        supprimerSeancePanel.add(new JLabel("ID Séance:"));
        idSuppressionField = new JTextField(5);
        supprimerSeancePanel.add(idSuppressionField);

        supprimerSeanceButton = new JButton("SUPPRIMER");
        supprimerSeanceButton.setBackground(Color.RED);
        supprimerSeancePanel.add(supprimerSeanceButton);

        return supprimerSeancePanel;
    }

    private JPanel createChercherEmploiPanel() {
        JPanel chercherEmploiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        chercherEmploiPanel.setBorder(BorderFactory.createTitledBorder("Emploi du Temps de la Semaine"));
        chercherEmploiPanel.setBackground(Color.PINK);

        chercherEmploiPanel.add(new JLabel("Classe:"));
        classeEmploiComboBox = new JComboBox<>(new String[]{"Classe 1", "Classe 2", "Classe 3"});
        chercherEmploiPanel.add(classeEmploiComboBox);

        chercherEmploiButton = new JButton("CHERCHER");
        chercherEmploiButton.setBackground(Color.GRAY);
        chercherEmploiPanel.add(chercherEmploiButton);

        return chercherEmploiPanel;
    }

    private JPanel createEmploiPanel() {
        JPanel emploiPanel = new JPanel(new BorderLayout());
        emploiPanel.setBorder(BorderFactory.createTitledBorder("Emploi du Temps de la Semaine"));
        emploiPanel.setBackground(Color.PINK);

        emploiTable = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Classe", "Jour", "Matière", "Heure", "Enseignant", "Contact Enseignant"}, 0));
        emploiTable.setBackground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(emploiTable);

        emploiPanel.add(tableScrollPane, BorderLayout.CENTER);

        return emploiPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SecondInterface();
        });
    }
}

