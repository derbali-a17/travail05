package ca.qc.bdeb.travail05.models.dao;

import java.util.List;

import ca.qc.bdeb.travail05.models.entities.Personne;

public interface IPersonneDAO {
    Personne ajouter(Personne personne, int idAdresse);
    List<Personne> trouver(int idAdresse);
}
