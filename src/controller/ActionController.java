package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Enseignant;
import model.Seance;
import model.Classe;

public class ActionController {
    private List<Enseignant> enseignants;
    private List<Seance> seances;
    private List<Classe> classes;

    public ActionController() {
        this.enseignants = new ArrayList<>();
        this.seances = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public Enseignant chercherEnseignantParNom(String nom) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getNom().equalsIgnoreCase(nom)) {
                return enseignant;
            }
        }
        return null;
    }
    public List<Seance> chercherSeances(String classe, String matiere) {
        // Implement the logic to search for seances based on class and matiere
        // Return a List<Seance> containing the search results
        // Example: 
        // return seanceRepository.chercherSeances(classe, matiere);
        return null;
    }
    public void enregistrerEnseignant( int idEnseignant, String nom, String prenom, String matiere) {

        Enseignant enseignant = new Enseignant(idEnseignant, nom, prenom, matiere);
        enseignants.add(enseignant);
    }

    public void modifierEnseignant(int idEnseignant, String nom, String prenom, String matiere) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getIdEnseignant() == idEnseignant) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setMatiere(matiere);
                break;
            }
        }
    }

    public void supprimerEnseignant(int idEnseignant) {
        enseignants.removeIf(enseignant -> enseignant.getIdEnseignant() == idEnseignant);
    }

    public void enregistrerSeance(int idClasse, int idEnseignant, String matiere, String jour, String heureDebut, String heureFin) {
        int idSeance = generateSeanceId();
        Seance seance = new Seance(idSeance, idClasse, idEnseignant, matiere, jour, heureDebut, heureFin);
        seances.add(seance);
    }

    public List<Seance> chercherSeancesParMatiereClasse(String classe, String matiere) {
        List<Seance> result = new ArrayList<>();

        for (Seance seance : seances) {
            if (seance.getIdClasse() == Integer.parseInt(classe) && seance.getMatiere().equalsIgnoreCase(matiere)) {
                result.add(seance);
            }
        }

        return result;
    }

    public void supprimerSeance(int idSeance) {
        seances.removeIf(seance -> seance.getIdSeance() == idSeance);
    }

    public List<Seance> chercherEmploiDuTemps(String classe) {
        List<Seance> emploiDuTemps = new ArrayList<>();

        for (Seance seance : seances) {
            if (seance.getIdClasse() == Integer.parseInt(classe)) {
                emploiDuTemps.add(seance);
            }
        }

        return emploiDuTemps;
    }

    public Map<String, List<Seance>> chercherEmploiDuTempsParJour(String classe) {
        Map<String, List<Seance>> emploiDuTempsParJour = new HashMap<>();

        // Initialize the map with empty lists for each day of the week
        for (String jour : new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"}) {
            emploiDuTempsParJour.put(jour, new ArrayList<>());
        }

        // Populate the map with matching seances
        for (Seance seance : seances) {
            if (seance.getIdClasse() == Integer.parseInt(classe)) {
                emploiDuTempsParJour.get(seance.getJour()).add(seance);
            }
        }

        return emploiDuTempsParJour;
    }



    private int generateSeanceId() {
        return seances.size() + 1;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public List<Seance> getSeances() {
        return seances;
    }
    
}
