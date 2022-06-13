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
                classeJoueur = new Classe();
                classeJoueur.setClasse(context, R.string.nomBarbare, R.string.descriptionBarbare, R.string.DVBarbare,
                        R.string.DVMoyBarbare, R.string.maitriseBarbare, R.string.armureBarbare,
                        R.string.armeBarbare, R.string.outilsBarbare, R.string.nbCompetenceBarbare,
                        R.string.competenceBarbare, R.string.equipementBarbare1, R.string.equipementBarbare2,
                        R.string.equipementBarbare3, R.string.equipementBarbare4, R.string.equipementBarbare5);
                break;
            case "Barde":
                classeJoueur.setClasse(context, R.string.nomBarde, R.string.descriptionBarde, R.string.DVBarde,
                        R.string.DVMoyBarde, R.string.maitriseBarde, R.string.armureBarde,
                        R.string.armeBarde, R.string.outilsBarde, R.string.nbCompetenceBarde,
                        R.string.competenceBarde, R.string.equipementBarde1, R.string.equipementBarde2,
                        R.string.equipementBarde3, R.string.equipementBarde4, R.string.equipementBarde5);
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
