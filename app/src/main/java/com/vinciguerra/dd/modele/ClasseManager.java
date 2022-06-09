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
        Map<String, String> couleur = new TreeMap<>();
        couleur.put("Guerrier", "10");
        couleur.put("Barbare", "12");
        couleur.put("Barde", "8");
        couleur.put("Clerc", "8");
        couleur.put("Druide", "8");
        couleur.put("Ensorceleur", "8");
        couleur.put("Magicien", "6");
        couleur.put("Moine", "8");
        couleur.put("Occultiste", "8");
        couleur.put("Paladin", "10");
        couleur.put("Rôdeur", "10");
        couleur.put("Roublard", "8");
        return couleur;
    }

    public static void getClasse (Context context, String classe){
        switch(classe){
            case "Guerrier":
                classeJoueur = new Classe();
                classeJoueur.setClasse(context, R.string.nomGuerrier, R.string.DVguerrier, R.string.DVMoyGuerrier, R.string.maitriseGuerrier, R.string.competenceGuerrier, R.string.equipementGuerrier);
                Log.d("DRAGON", "classe PDV :" + classeJoueur.getPDV() );
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
