package model;

public class Seance {
    private int idSeance;
    private int idClasse;
    private int idEnseignant;
    private String matiere;
    private String jour;
    private String heureDebut;
    private String heureFin;

    public Seance(int idSeance, int idClasse, int idEnseignant, String matiere, String jour, String heureDebut, String heureFin) {
        this.idSeance = idSeance;
        this.idClasse = idClasse;
        this.idEnseignant = idEnseignant;
        this.matiere = matiere;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String  getMatiere() {
        return matiere;
    }

    public void setMatiere(String  matiere) {
        this.matiere = matiere;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
}
