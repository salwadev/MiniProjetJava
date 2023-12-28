package controller;

import view.EnseignantView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnseignantController {
    private EnseignantView enseignantView;

    public EnseignantController(EnseignantView enseignantView) {
        this.enseignantView = enseignantView;
        initializeListeners();
    }

    private void initializeListeners() {
        enseignantView.getEnregistrerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle ENREGISTRER button click
                String matricule = enseignantView.getMatriculeField().getText();
                String nom = enseignantView.getNomField().getText();
                String contact = enseignantView.getContactField().getText();
                
                // Add your logic to save the data to the database or perform other actions
                System.out.println("Enregistrer button clicked");
            }
        });

        enseignantView.getSupprimerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle SUPPRIMER button click
                // Get matricule and perform deletion
                System.out.println("Supprimer button clicked");
            }
        });

        enseignantView.getModifierButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle MODIFIER button click
                // Get matricule and update the data
                System.out.println("Modifier button clicked");
            }
        });

        enseignantView.getChercherButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle CHERCHER button click
                // Get matricule or nom and perform a search
                System.out.println("Chercher button clicked");
            }
        });
    }
}
