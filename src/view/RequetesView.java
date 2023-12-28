package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequetesView extends JFrame {

    // Elements de l'interface
    private JButton btnChercherSeances;
    private JButton btnSupprimerSeance;
    private JButton btnChercherEmploiDuTemps;

    // ... autres éléments graphiques

    public RequetesView() {
        // Initialisation des composants

        // Action lors du clic sur le bouton "CHERCHER" pour les séances
        btnChercherSeances.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour afficher la liste des séances
                // Utilisez le contrôleur correspondant
            }
        });

        // Action lors du clic sur le bouton "SUPPRIMER" pour une séance
        btnSupprimerSeance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour supprimer une séance
                // Utilisez le contrôleur correspondant
            }
        });

        // Action lors du clic sur le bouton "CHERCHER" pour l'emploi du temps
        btnChercherEmploiDuTemps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour afficher l'emploi du temps
                // Utilisez le contrôleur correspondant
            }
        });
    }
}
