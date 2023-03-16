package ca.qc.bdeb.travail05.models.dao;

import java.util.List;

import ca.qc.bdeb.travail05.models.entities.Adresse;

public interface IAdresseDAO {
    Adresse ajouter(Adresse adresse);
    List<Adresse> trouver();
}
