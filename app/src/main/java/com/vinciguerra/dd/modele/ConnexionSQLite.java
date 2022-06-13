package com.vinciguerra.dd.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnexionSQLite extends SQLiteOpenHelper {
    private static final String DB_NAME = "DandD";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME ="races";
    private static final String ID_COL = "race";
    private static final String RACE_COL = "sousrace";
    private static final String TABLE_PERSONNAGE = "personnages";
    private static final String ID_COL_PERSONNAGE = "numero";
    private static final String NOM_PERSONNAGE = "nom";
    private static final String RACE_PERSONNAGE = "race";
    private static final String SOUS_ESPECE_PERSONNAGE = "sousespece";
    private static final String CLASSE_PERSONNAGE = "classe";
    private static final String HISTORIQUE_PERSONNAGE = "historique";
    private static final String PSEUDO_JOUEUR = "pseudojoueur";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL+ " TEXT PRIMARY KEY, " +RACE_COL+" TEXT)";
    private static final String INSERT_RACE = "INSERT INTO `races` (`race`) VALUES\n" +
            "('Elfe'),\n" +
            "('Halfelin'),\n" +
            "('Humain'),\n" +
            "('Nain'),\n" +
            "('Demi-elfe'),\n" +
            "('Demi-orc'),\n" +
            "('Drakéide'),\n" +
            "('Gnome'),\n" +
            "('Tieffelin');";

    private static final String CREATE_TABLE_PERSONNAGE = "CREATE TABLE " + TABLE_PERSONNAGE + " ("
            + ID_COL_PERSONNAGE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOM_PERSONNAGE + " TEXT,"
            + RACE_PERSONNAGE + " TEXT, "
            + SOUS_ESPECE_PERSONNAGE + " TEXT,"
            + CLASSE_PERSONNAGE + " TEXT,"
            + HISTORIQUE_PERSONNAGE + " TEXT, "
            + PSEUDO_JOUEUR + " TEXT)";

    public ConnexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
        db.execSQL(INSERT_RACE);
        db.execSQL(CREATE_TABLE_PERSONNAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public void ajoutNouveauPersonnage (String nomPersonnage, String racePersonnage, String sousEspecePersonnage,
                                        String classePersonnage, String historiquePersonnage, String pseudoJoueur ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NOM_PERSONNAGE, nomPersonnage);
        values.put(RACE_PERSONNAGE, racePersonnage);
        values.put(SOUS_ESPECE_PERSONNAGE, sousEspecePersonnage);
        values.put(CLASSE_PERSONNAGE, classePersonnage);
        values.put(HISTORIQUE_PERSONNAGE, historiquePersonnage);
        values.put(PSEUDO_JOUEUR, pseudoJoueur);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_PERSONNAGE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
}
