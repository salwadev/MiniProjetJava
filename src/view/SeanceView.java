package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeanceView extends JFrame {

    // Elements de l'interface
    private JButton btnEnregistrerSeance;
    private JButton btnRequetes;

    // ... autres éléments graphiques

    public SeanceView() {
        // Initialisation des composants

        // Action lors du clic sur le bouton "ENREGISTRER"
        btnEnregistrerSeance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour enregistrer une séance dans la base de données
                // Utilisez le contrôleur correspondant
            }
        });

        // Action lors du clic sur le bouton "REQUETES"
        btnRequetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir l'interface graphique des requêtes
                // Utilisez le contrôleur correspondant
            }
        });
    }
}
