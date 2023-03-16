package ca.qc.bdeb.travail05.models.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "travail05.db";
    public static final int DB_VERSION = 1;

    public MyDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Adresse (id INTEGER PRIMARY KEY AUTOINCREMENT, ville TEXT, codePostal TEXT)");
        db.execSQL("CREATE TABLE Personne (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, dateNaissance TEXT, idAdresse INTEGER, FOREIGN KEY(idAdresse) REFERENCES Adresse(id))");
        //peulper les deux tables avec un jeu de données initiales
        db.execSQL("INSERT INTO Adresse (ville, codePostal) VALUES ('Montreal', 'H5D 7D9')");
        db.execSQL("INSERT INTO Personne (nom, dateNaissance, idAdresse) VALUES ('Test Test', '2000-03-15', 1)");
        db.execSQL("INSERT INTO Personne (nom, dateNaissance, idAdresse) VALUES ('Test2 Test2', '1999-11-25', 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
