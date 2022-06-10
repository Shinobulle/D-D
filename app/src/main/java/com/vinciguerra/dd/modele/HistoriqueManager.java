package com.vinciguerra.dd.modele;

import android.content.Context;
import android.view.View;

import com.vinciguerra.dd.historique.historique;
import com.vinciguerra.dd.R;

import java.util.Map;
import java.util.TreeMap;

public class HistoriqueManager {
    public static historique historiqueJoueur;

    public static Map<String, String> getListHistorique(){
        Map<String, String> listHistorique = new TreeMap<>();
        listHistorique.put("Acolyte", "1");
        listHistorique.put("Artisan", "2");
        listHistorique.put("Artiste", "3");
        listHistorique.put("Charlatan", "4");
        listHistorique.put("Criminel", "5");
        listHistorique.put("Enfant des rues", "6");
        listHistorique.put("Ermite", "7");
        listHistorique.put("Héros du peuple", "8");
        listHistorique.put("Marin", "9");
        listHistorique.put("Noble", "10");
        listHistorique.put("Sage", "11");
        listHistorique.put("Sauvageon", "12");
        listHistorique.put("Soldat", "13");
        return listHistorique;
    }

    public static void getHistorique (Context context, String historique){
        switch (historique){
            case "Soldat" :
                historiqueJoueur = new historique();
                historiqueJoueur.setHistorique(context, R.string.nomHistoriqueSoldat, R.string.descriptionSoldat, R.string.competenceSoldat,
                        R.string.outilSoldat, R.string.langueSoldat, R.string.equipementSoldat, R.string.nomCapaciteSoldat, R.string.capaciteSoldat);
                break;
            case "Acolyte" :
                historiqueJoueur = new historique();
                historiqueJoueur.setHistorique(context, R.string.nomHistoriqueAcolyte, R.string.descriptionAcolyte, R.string.competenceAcolyte,
                        R.string.outilAcolyte, R.string.langueAcolyte, R.string.equipementAcolyte, R.string.nomCapaciteAcolyte, R.string.capaciteAcolyte);
                break;
            case "Artisan" :
                break;
            case "Artiste" :
                break;
            case "Charlatan" :
                break;
            case "Enfant des rues" :
                break;
            case "Ermite" :
                break;
            case "Héros du peuple" :
                break;
            case "Marin" :
                break;
            case "Noble" :
                break;
            case "Sauvageon" :
                break;
        }
    }
}
