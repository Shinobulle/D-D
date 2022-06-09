package com.vinciguerra.dd.classe;

import android.content.Context;
import android.content.res.Resources;

import com.vinciguerra.dd.R;

public class Classe {
    private String nomClasse;
    private String PDV;
    private String DVClasse;
    private String DVMoyClasse;
    private String maitrise;
    private String equipement;

    public void setClasse(Context context, int nomClasse, int DVCLasse, int DVMoyClasse, int maitrise, int competence, int equipement ){
        Resources res = context.getResources();
        setNomClasse(res.getString(nomClasse));
        setDVClasse(res.getString(DVCLasse));
        setDVMoyClasse(res.getString(DVMoyClasse));
        setPDV(res.getString(R.string.titrePDV1)+" 1d"+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                res.getString(R.string.titrePDV2)+" "+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                res.getString(R.string.titrePDV3)+"1d"+ getDVClasse() +" (ou "+ getDVMoyClasse() +") + votre modificateur de Constitution \n");
        setMaitrise(res.getString(maitrise)+ res.getString(competence));
        setEquipement(res.getString(equipement));
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
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
