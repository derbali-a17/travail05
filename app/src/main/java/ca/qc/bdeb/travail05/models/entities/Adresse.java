package ca.qc.bdeb.travail05.models.entities;

public class Adresse {
    private int id;
    private String ville;
    private String codePostal;

    public Adresse() {
    }

    public Adresse(int id, String ville, String codePostal) {
        this.id = id;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}
