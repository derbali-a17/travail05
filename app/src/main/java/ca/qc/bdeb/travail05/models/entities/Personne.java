package ca.qc.bdeb.travail05.models.entities;

public class Personne {
    private int id;
    private String nom;
    private String dateNaissance;
    private int idAdresse;

    public Personne() {
    }

    public Personne(int id, String nom, String dateNaissance, int idAdresse) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.idAdresse = idAdresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", idAdresse=" + idAdresse +
                '}';
    }
}
