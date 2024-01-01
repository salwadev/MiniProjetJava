
package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstInterface {
    private JFrame frame;
    private JTextField matriculeField;
    private JTextField nomField;
    private JTextField contactField;
    private JButton enregistrerButton;
    private JButton supprimerButton;
    private JButton modifierButton;
    private JButton chercherButton;
    private JButton requetesButton;
    private JTable enseignantTable;

    private JTextField classeField;
    private JTextField matiereField;
    private JComboBox<String> joursComboBox;
    private JComboBox<String> heuresComboBox;
    private JComboBox<String> enseignantComboBox;
    private JButton enregistrerSeanceButton;
    private JButton requetesSeanceButton;
    private JTable seanceTable;

    public FirstInterface() {
        initialize();
        applyDesign();
        addListeners();
    }

    private void applyDesign() {
        // Set UIManager properties for a more professional look and feel
        UIManager.put("TableHeader.font", UIManager.getFont("Label.font").deriveFont(Font.BOLD));
        UIManager.put("Button.background", Color.GREEN);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", UIManager.getFont("Label.font"));
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));  // Remove focus border
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame();
        frame.setTitle("Gestion des Enseignants et Séances de Cours");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.getContentPane().setBackground(Color.PINK);

        JPanel enseignantPanel = createEnseignantPanel();
        JPanel seancePanel = createSeancePanel();

        frame.add(enseignantPanel);
        frame.add(seancePanel);

        frame.setVisible(true);
    }

    private JPanel createEnseignantPanel() {
        JPanel enseignantPanel = new JPanel(new BorderLayout());
        enseignantPanel.setBorder(BorderFactory.createTitledBorder("Formulaire d'enregistrement des enseignants"));
        enseignantPanel.setBackground(Color.PINK);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(new JLabel("Matricule:"));
        matriculeField = new JTextField();
        formPanel.add(matriculeField);

        formPanel.add(new JLabel("Nom:"));
        nomField = new JTextField();
        formPanel.add(nomField);

        formPanel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        formPanel.add(contactField);

        chercherButton = new JButton("CHERCHER");
        chercherButton.setBackground(Color.GRAY);

        requetesButton = new JButton("REQUETES");
        requetesButton.setBackground(Color.ORANGE);

        enregistrerButton = new JButton("ENREGISTRER");
        enregistrerButton.setBackground(Color.GREEN);
        supprimerButton = new JButton("SUPPRIMER");
        supprimerButton.setBackground(Color.RED);
        modifierButton = new JButton("MODIFIER");
        modifierButton.setBackground(Color.BLUE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(chercherButton);
        buttonPanel.add(enregistrerButton);
        buttonPanel.add(supprimerButton);
        buttonPanel.add(modifierButton);
        buttonPanel.add(requetesButton);

        enseignantTable = new JTable(new DefaultTableModel(
                new Object[]{"Matricule", "Nom", "Contact"}, 0));
        enseignantTable.setBackground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(enseignantTable);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.NORTH);
        leftPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel enseignantRowPanel = new JPanel(new GridLayout(1, 2));
        enseignantRowPanel.add(leftPanel);
        enseignantRowPanel.add(tableScrollPane);

        enseignantPanel.add(enseignantRowPanel, BorderLayout.CENTER);

        return enseignantPanel;
    }

    private JPanel createSeancePanel() {
        JPanel seancePanel = new JPanel(new BorderLayout());
        seancePanel.setBorder(BorderFactory.createTitledBorder("Formulaire d'enregistrement des séances de cours"));
        seancePanel.setBackground(Color.PINK);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.add(new JLabel("Classe:"));
        classeField = new JTextField();
        formPanel.add(classeField);

        formPanel.add(new JLabel("Matière:"));
        matiereField = new JTextField();
        formPanel.add(matiereField);

        formPanel.add(new JLabel("Jour:"));
        joursComboBox = new JComboBox<>(new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"});
        formPanel.add(joursComboBox);

        formPanel.add(new JLabel("Heure:"));
        heuresComboBox = new JComboBox<>(new String[]{"8h-10h", "10h-12h", "14h-16h", "16h-18h"});
        formPanel.add(heuresComboBox);

        formPanel.add(new JLabel("Enseignant:"));
        enseignantComboBox = new JComboBox<>(new String[]{"Enseignant 1", "Enseignant 2", "Enseignant 3"});
        formPanel.add(enseignantComboBox);

        enregistrerSeanceButton = new JButton("ENREGISTRER");
        enregistrerSeanceButton.setBackground(Color.GREEN);
        requetesSeanceButton = new JButton("REQUETES");
        requetesSeanceButton.setBackground(Color.ORANGE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(enregistrerSeanceButton);
        buttonPanel.add(requetesSeanceButton);

        seanceTable = new JTable(new DefaultTableModel(
                new Object[]{"Classe", "Matière", "Jour", "Heure", "Enseignant"}, 0));
        seanceTable.setBackground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(seanceTable);

        JPanel seanceRowPanel = new JPanel(new GridLayout(1, 2));
        seanceRowPanel.add(formPanel);
        seanceRowPanel.add(tableScrollPane);

        seancePanel.add(seanceRowPanel, BorderLayout.CENTER);

        return seancePanel;
    }

    private void addListeners() {
        chercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for chercherButton
            }
        });

        requetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSecondInterface();
            }
        });

        // Add listeners for other buttons as needed
    }

    private void openSecondInterface() {
        // Create an instance of SecondInterface
        SecondInterface secondInterface = new SecondInterface();

        // Make the SecondInterface visible
        secondInterface.getFrame().setVisible(true);

        // Hide the current FirstInterface frame (optional)
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getMatriculeField() {
        return matriculeField;
    }

    public JTextField getNomField() {
        return nomField;
    }

    public JTextField getContactField() {
        return contactField;
    }

    public JButton getEnregistrerButton() {
        return enregistrerButton;
    }

    public JButton getSupprimerButton() {
        return supprimerButton;
    }

    public JButton getModifierButton() {
        return modifierButton;
    }

    public JButton getChercherButton() {
        return chercherButton;
    }

    public JButton getRequetesButton() {
        return requetesButton;
    }

    public JTextField getClasseField() {
        return classeField;
    }

    public JTextField getMatiereField() {
        return matiereField;
    }

    public JComboBox<String> getJoursComboBox() {
        return joursComboBox;
    }

    public JComboBox<String> getHeuresComboBox() {
        return heuresComboBox;
    }

    public JComboBox<String> getEnseignantComboBox() {
        return enseignantComboBox;
    }

    public JButton getEnregistrerSeanceButton() {
        return enregistrerSeanceButton;
    }

    public JButton getRequetesSeanceButton() {
        return requetesSeanceButton;
    }

    public JTable getEnseignantTable() {
        return enseignantTable;
    }

    public JTable getSeanceTable() {
        return seanceTable;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FirstInterface();
        });
    }
}

