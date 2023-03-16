package ca.qc.bdeb.travail05.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.dao.AdresseDAOImpl;
import ca.qc.bdeb.travail05.models.dao.IAdresseDAO;
import ca.qc.bdeb.travail05.models.dao.IPersonneDAO;
import ca.qc.bdeb.travail05.models.dao.PersonneDAOImpl;
import ca.qc.bdeb.travail05.models.entities.Adresse;
import ca.qc.bdeb.travail05.models.entities.Personne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        IAdresseDAO dao = new AdresseDAOImpl(this);
        //ajouter une nouvelle adresse
        /*Adresse adresse = new Adresse();
        adresse.setVille("Laval");
        adresse.setCodePostal("F7G 8S2");
        adresse = dao.ajouter(adresse);
        if(adresse != null)
            Log.d("DBDebug", "Nouvelle adresess: "  + adresse.toString());
        else
            Log.d("DBDebug", "Erreur lors l'ajout d'une adresse");
         */
        List<Adresse> adresses = dao.trouver();
        Log.d("DBDebug", "Il y  a " + adresses.size()  + " adresses trouvées");
        for (Adresse adr:
             adresses) {
            Log.d("DBDebug", adr.toString());
        }


        IPersonneDAO dao2 = new PersonneDAOImpl(this);
        //ajouter une nouvelle personne
       Personne personne = new Personne();
       personne.setNom("Test4 Test4");
       personne.setDateNaissance("2001-09-09");
       personne = dao2.ajouter(personne, 1);
        if(personne != null)
            Log.d("DBDebug", "Nouvelle personne: "  + personne.toString());
        else
            Log.d("DBDebug", "Erreur lors l'ajout d'une personne");

        //trouver les personnes

        List<Personne> personnes = dao2.trouver(1);
        Log.d("DBDebug", "Il y  a " + personnes.size()  + " personnes trouvées");
        for (Personne per:
                personnes) {
            Log.d("DBDebug", per.toString());
        }
    }
}