package model;

public class Enseignant {
    private int idEnseignant;
    private String nom;
    private String prenom;
    private String matiere;

    public Enseignant(int idEnseignant, String nom, String prenom, String matiere) {
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
