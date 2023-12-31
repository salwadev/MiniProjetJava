package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ActionController;
import model.Enseignant;

import java.awt.*;
import java.awt.event.ActionEvent;

public class FirstInterface {
    private JFrame frame;
    private JTextField nomField;
    private JButton enregistrerButton;
    private JButton supprimerButton;
    private JButton modifierButton;
    private JButton chercherButton;
    private JTable enseignantTable;
    private JTextField prenomField;
    private JTextField matriculeField;
    private JTextField classeField;
    private JTextField matiereField;
    private JComboBox<String> joursComboBox;
    private JComboBox<String> heuresComboBox;
    private JComboBox<String> enseignantComboBox;
    private JButton enregistrerSeanceButton;
    private JTable seanceTable;
    private ActionController controller;

    public FirstInterface(ActionController controller) {
        this.controller = controller;
        initialize();
        applyDesign();
        addListeners();
    }

    private void applyDesign() {
        UIManager.put("TableHeader.font", UIManager.getFont("Label.font").deriveFont(Font.BOLD));
        UIManager.put("Button.background", Color.GREEN);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", UIManager.getFont("Label.font"));
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));
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

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Nom:"));
        nomField = new JTextField();
        formPanel.add(nomField);

        chercherButton = new JButton("CHERCHER");
        chercherButton.setBackground(Color.GRAY);

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

        enseignantTable = new JTable(new DefaultTableModel(
                new Object[]{"Nom"}, 0));
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

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
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

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(enregistrerSeanceButton);

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
        chercherButton.addActionListener(e -> chercherEnseignant());
        enregistrerButton.addActionListener(e -> enregistrerEnseignant());
        supprimerButton.addActionListener(e -> supprimerEnseignant());
        modifierButton.addActionListener(e -> modifierEnseignant());
        enregistrerSeanceButton.addActionListener(e -> enregistrerSeance());
    }

    private void chercherEnseignant() {
        String nom = nomField.getText();
        Enseignant enseignant = controller.chercherEnseignantParNom(nom);
        // Update the interface based on the search result
        // Display information in the interface...
    }

    private void enregistrerEnseignant() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String matiere = matiereField.getText();
        int idEnseignant = Integer.parseInt(matriculeField.getText());
    
        // Make sure to call the correct method with the updated parameters
        controller.enregistrerEnseignant(idEnseignant, nom, prenom, matiere);
        // Update the interface after registration
    }
    
    
    private void modifierEnseignant() {
        int idEnseignant = Integer.parseInt(matriculeField.getText()); // Set idEnseignant to matriculeField
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String matiere = matiereField.getText();
        controller.modifierEnseignant(idEnseignant, nom, prenom, matiere);
        // Update the interface after modification
    }

    private void supprimerEnseignant() {
        int idEnseignant = Integer.parseInt(matriculeField.getText());
        controller.supprimerEnseignant(idEnseignant);
        // Update the interface after deletion
    }



    private void enregistrerSeance() {
        int idClasse = Integer.parseInt(classeField.getText());
        int idEnseignant = Integer.parseInt(enseignantComboBox.getSelectedItem().toString());
        String matiere = matiereField.getText();
        String jour = joursComboBox.getSelectedItem().toString();
        String heureDebut = heuresComboBox.getSelectedItem().toString().split("-")[0].trim();
        String heureFin = heuresComboBox.getSelectedItem().toString().split("-")[1].trim();

        controller.enregistrerSeance(idClasse, idEnseignant, matiere, jour, heureDebut, heureFin);
        // Update the interface after saving the schedule
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getNomField() {
        return nomField;
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

    public JTable getEnseignantTable() {
        return enseignantTable;
    }

    public JTable getSeanceTable() {
        return seanceTable;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ActionController actionController = new ActionController();
            new FirstInterface(actionController);
        });
    }
}
