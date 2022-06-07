package com.vinciguerra.dd.modele;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vinciguerra.dd.R;
import com.vinciguerra.dd.races.Drakeide;
import com.vinciguerra.dd.races.Race;

import java.util.HashMap;
import java.util.Map;

public class RaceManager {
    public static Race joueur;

    public static Map<String, String> getListRace(Context context){
        ConnexionSQLite connexion = new ConnexionSQLite(context,"DandD", null, 1 );
        SQLiteDatabase bdd = connexion.getWritableDatabase();
        String sqlRequete = "SELECT race,sousrace FROM races";
        Map<String, String> tRaces = new HashMap<String, String>();

        Cursor c = bdd.rawQuery(sqlRequete,null);
        if(c.getCount() > 0){
            c.moveToFirst();
            while(c.moveToNext()){
                Log.d("Dragon", "getListRace: " + c.getString(0));
                tRaces.put(c.getString(0),c.getString(1));
            }
            c.close();}
        return tRaces;
    }
    public static void getRace (String race, Context context, View v){
        switch (race){
            case "Drakéide":
                joueur = new Drakeide();
                joueur.setInfo(context, race, R.string.drkCarac,
                        R.string.drkAge,
                        R.string.drkTaille,
                        R.string.vitesse,
                        R.string.drkTrait1,
                        R.string.drkTrait2,R.string.drkTrait3,
                        R.string.drkTrait4,
                        R.string.drkLangue, R.string.drkTitreTrait1,
                        R.string.drkTitreTrait2, R.string.drkTitreTrait3,
                        R.string.drkTitreTrait4);
                break;
            case "Demi-elfe":
                break;
            case "Demi-orc":
                break;
            case "Elfe":
                break;
            case "Gnome" :
                break;
            case "Halfelin" :
                break;
            case "Humain" :
                break;
            case "Nain":
                break;
            case "Tieffelin" :
                break;
        }

    }
}
