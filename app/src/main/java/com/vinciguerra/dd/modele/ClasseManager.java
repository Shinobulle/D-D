package com.vinciguerra.dd.modele;

import android.content.Context;
import android.util.Log;

import com.vinciguerra.dd.CreationGuidee;
import com.vinciguerra.dd.R;
import com.vinciguerra.dd.classe.Classe;

import java.util.Map;
import java.util.TreeMap;

public class ClasseManager {
    public static Classe classeJoueur;

    public static Map<String, String> getListClasse(){
        Map<String, String> listClasse = new TreeMap<>();
        listClasse.put("Guerrier", "10");
        listClasse.put("Barbare", "12");
        listClasse.put("Barde", "8");
        listClasse.put("Clerc", "8");
        listClasse.put("Druide", "8");
        listClasse.put("Ensorceleur", "8");
        listClasse.put("Magicien", "6");
        listClasse.put("Moine", "8");
        listClasse.put("Occultiste", "8");
        listClasse.put("Paladin", "10");
        listClasse.put("Rôdeur", "10");
        listClasse.put("Roublard", "8");
        return listClasse;
    }

    public static void getClasse (Context context, String classe){
        switch(classe){
            case "Guerrier":
                classeJoueur = new Classe();
                classeJoueur.setClasse(context, R.string.nomGuerrier, R.string.descriptionGuerrier,R.string.DVguerrier, R.string.DVMoyGuerrier,R.string.maitriseGuerrier, R.string.armureGuerrier,
                        R.string.armeGuerrier, R.string.outilsGuerrier, R.string.nbCompetenceGuerrier,
                        R.string.competenceGuerrier, R.string.equipementGuerrier1, R.string.equipementGuerrier2,
                        R.string.equipementGuerrier3, R.string.equipementGuerrier4, R.string.equipementGuerrier5);
                break;
            case "Barbare":
                break;
            case "Barde":
                break;
            case "Clerc":
                break;
            case "Druide":
                break;
            case "Ensorceleur":
                break;
            case "Magicien":
                break;
            case "Moine":
                break;
            case "Occultiste":
                break;
            case "Paladin":
                break;
            case "Rôdeur":
                break;
            case "Roublard":
                break;
        }
    }
}
