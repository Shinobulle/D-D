package com.vinciguerra.dd.classe;

import android.content.Context;
import android.content.res.Resources;

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
        setPDV("<b>DV :</b> 1d"+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                "<b>PV au niveau 1 : </b>"+ getDVClasse() + "+ votre modificateur de Constitution \n" +
                "<b>PV aux niveaux suivants :</b> 1d"+ getDVClasse() +" (ou "+ getDVMoyClasse() +") + votre modificateur de Constitution \n");
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
