package com.vinciguerra.dd.classe;

import android.content.Context;
import android.content.res.Resources;

import com.vinciguerra.dd.R;

public class Classe {
    private String nomClasse;
    private String descriptionClasse;
    private String PDV;
    private String DVClasse;
    private String DVMoyClasse;
    private String maitrise;
    private String equipement;

    public void setClasse(Context context, int nomClasse, int descriptionClasse, int DVCLasse, int DVMoyClasse, int maitrise,
                          int armure, int arme, int outil, int nbCompetence,int competence,
                          int equipement1, int equipement2, int equipement3, int equipement4, int equipement5  ){
        Resources res = context.getResources();
        setNomClasse(res.getString(nomClasse));
        setDescriptionClasse(res.getString(descriptionClasse));
        setDVClasse(res.getString(DVCLasse));
        setDVMoyClasse(res.getString(DVMoyClasse));
        setPDV(res.getString(R.string.titrePDV1)+" 1d"+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                res.getString(R.string.titrePDV2)+" "+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                res.getString(R.string.titrePDV3)+"1d"+ getDVClasse() +" (ou "+ getDVMoyClasse() +") + votre modificateur de Constitution");
        setMaitrise("Armures : "+ res.getString(armure) + "\n" +
                        "Armes : " + res.getString(arme) + "\n" +
                        "Outils : "+ res.getString(outil) + "\n" +
                        "Jets de sauvegarde : " + res.getString(maitrise)+ "\n" +
                "Compétences : choisissez" + res.getString(nbCompetence) + " parmi "+res.getString(competence));
        setEquipement("Vous commencez avec l'équipement suivant, en plus de l'équipement accordé par votre historique : \n \n"+
                res.getString(equipement1)+"\n"+
                res.getString(equipement2)+"\n"+
                res.getString(equipement3)+"\n"+
                res.getString(equipement4)+"\n"+
                res.getString(equipement5));
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getDescriptionClasse() {
        return descriptionClasse;
    }

    public void setDescriptionClasse(String descriptionClasse) {
        this.descriptionClasse = descriptionClasse;
    }

    public String getPDV() {
        return PDV;
    }

    public void setPDV(String PDV) {
        this.PDV = PDV;
    }

    public String getDVClasse() {
        return DVClasse;
    }

    public void setDVClasse(String DVClasse) {
        this.DVClasse = DVClasse;
    }

    public String getDVMoyClasse() {
        return DVMoyClasse;
    }

    public void setDVMoyClasse(String DVMoyClasse) {
        this.DVMoyClasse = DVMoyClasse;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public String getMaitrise() {
        return maitrise;
    }

    public void setMaitrise(String maitrise) {
        this.maitrise = maitrise;
    }
}
