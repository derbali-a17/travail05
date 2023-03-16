package ca.qc.bdeb.travail05.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.travail05.models.database.MyDbHelper;
import ca.qc.bdeb.travail05.models.entities.Adresse;
import ca.qc.bdeb.travail05.models.entities.Personne;

public class PersonneDAOImpl implements IPersonneDAO{
    Context context;
    MyDbHelper dbHelper;

    public PersonneDAOImpl(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
    }

    @Override
    public Personne ajouter(Personne personne, int idAdresse) {
        SQLiteDatabase db  = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nom", personne.getNom());
        values.put("dateNaissance", personne.getDateNaissance());
        values.put("idAdresse", idAdresse);


        int rowID = (int) db.insert("Personne", null, values);
        if(rowID != -1){
            personne.setId(rowID);
            personne.setIdAdresse(idAdresse);
            return personne;
        }
        return null;

    }

    @Override
    public List<Personne> trouver(int idAdresse) {
        SQLiteDatabase db  = dbHelper.getReadableDatabase();
        String request = "SELECT * FROM Personne WHERE idAdresse = " + idAdresse;
        Cursor cursor = db.rawQuery(request, null);
        if(cursor != null) {
            List<Personne> people = new ArrayList<>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                people.add(new Personne(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
                cursor.moveToNext();
            }
            return people;
        }
        return null;

    }
}
