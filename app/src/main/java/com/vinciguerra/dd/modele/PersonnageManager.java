package com.vinciguerra.dd.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class PersonnageManager {

    public static Map<String, String> getListPseudo(Context context){

        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT pseudojoueur, nom FROM personnages";
        Map<String, String> tPersonnages = new HashMap<String, String>();
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0){
            c.moveToFirst();
            if (c.getCount() < 2){
                tPersonnages.put(c.getString(0),c.getString(1));
            }
            while(c.moveToNext()){
                tPersonnages.put(c.getString(0),c.getString(1));
            }
            c.close();}
        return tPersonnages;
    }

    public static Map<String, String> getListPersonnage(Context context, String pseudoJoueur){

        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT nom, race FROM personnages WHERE pseudojoueur = '" + pseudoJoueur + "'";
        Map<String, String> tPersonnages = new HashMap<String, String>();
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0){
            c.moveToFirst();
            if (c.getCount() < 2){
                tPersonnages.put(c.getString(0),c.getString(1));
            }
            while(c.moveToNext()){
                tPersonnages.put(c.getString(0),c.getString(1));
            }
            c.close();}
        return tPersonnages;
    }

    public static String getRacePersonnage (Context context, String nom){
        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT race FROM personnages where nom = '"+ nom +"'" ;
        String racePersonnage = null;
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0) {
            c.moveToFirst();
            if (c.getCount() == 1) {
                racePersonnage = c.getString(0);
            }
        }
        return racePersonnage;
    }

    public static String getSousEspecePersonnage (Context context, String nom){
        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT sousespece FROM personnages where nom = '"+ nom +"'" ;
        String sousEspecePersonnage = null;
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0) {
            c.moveToFirst();
            if (c.getCount() == 1) {
                sousEspecePersonnage = c.getString(0);
            }
        }
        return sousEspecePersonnage;
    }

    public static String getClassePersonnage (Context context, String nom){
        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT classe FROM personnages where nom = '"+ nom +"'" ;
        String racePersonnage = null;
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0) {
            c.moveToFirst();
            if (c.getCount() == 1) {
                racePersonnage = c.getString(0);
            }
        }
        return racePersonnage;
    }

    public static String getHistoriquePersonnage (Context context, String nom){
        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT historique FROM personnages where nom = '"+ nom +"'" ;
        String racePersonnage = null;
        Cursor c = bdd.rawQuery(sqlRequete,null);

        if(c.getCount() > 0) {
            c.moveToFirst();
            if (c.getCount() == 1) {
                racePersonnage = c.getString(0);
            }
        }
        return racePersonnage;
    }
}
