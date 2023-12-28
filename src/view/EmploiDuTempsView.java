package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmploiDuTempsView extends JFrame {

    // Elements de l'interface
    private JButton btnChercherEmploiDuTemps;

    // ... autres éléments graphiques

    public EmploiDuTempsView() {
        // Initialisation des composants

        // Action lors du clic sur le bouton "CHERCHER"
        btnChercherEmploiDuTemps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour afficher l'emploi du temps
                // Utilisez le contrôleur correspondant
            }
        });
    }
}
