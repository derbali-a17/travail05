package ca.qc.bdeb.travail05.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.travail05.models.database.MyDbHelper;
import ca.qc.bdeb.travail05.models.entities.Adresse;

public class AdresseDAOImpl implements IAdresseDAO{
    Context context;
    MyDbHelper dbHelper;

    public AdresseDAOImpl(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
    }


    @Override
    public Adresse ajouter(Adresse adresse) {
        SQLiteDatabase db  = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ville", adresse.getVille());
        values.put("codePostal", adresse.getCodePostal());

        int rowID = (int) db.insert("Adresse", null, values);
        if(rowID != -1){
            adresse.setId(rowID);
            return adresse;
        }
        return null;
    }

    @Override
    public List<Adresse> trouver() {
        SQLiteDatabase db  = dbHelper.getReadableDatabase();
        String request = "SELECT * FROM Adresse";
        Cursor cursor = db.rawQuery(request, null);
        if(cursor != null) {
            List<Adresse> adresses = new ArrayList<>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                adresses.add(new Adresse(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                cursor.moveToNext();
            }
            return adresses;
        }
        return null;
    }
}
