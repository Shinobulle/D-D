package com.vinciguerra.dd.historique;

import android.content.Context;
import android.content.res.Resources;

public class historique {
    private String nomHistorique;
    private String descriptionHistorique;
    private String competenceHistorique;
    private String outilHistorique;
    private String langueHistorique;
    private String equipementHistorique;
    private String nomCapaciteHistorique;
    private String capaciteHistorique;

    public void setHistorique(Context context, int nomHistorique, int descriptionHistorique, int comptenceHistorique,
                              int outilHistorique, int langueHistorique, int equipementHistorique, int nomCapaciteHistorique, int capaciteHistorique){
        Resources res = context.getResources();
        setNomHistorique(res.getString(nomHistorique));
        setDescriptionHistorique(res.getString(descriptionHistorique));
        setCompetenceHistorique(res.getString(comptenceHistorique));
        setOutilHistorique(res.getString(outilHistorique));
        setLangueHistorique(res.getString(langueHistorique));
        setEquipementHistorique(res.getString(equipementHistorique));
        setNomCapaciteHistorique("Capacité : "+ res.getString(nomCapaciteHistorique));
        setCapaciteHistorique(res.getString(capaciteHistorique));
    }

    public String getNomHistorique() {
        return nomHistorique;
    }

    public void setNomHistorique(String nomHistorique) {
        this.nomHistorique = nomHistorique;
    }

    public String getDescriptionHistorique() {
        return descriptionHistorique;
    }

    public void setDescriptionHistorique(String descriptionHistorique) {
        this.descriptionHistorique = descriptionHistorique;
    }

    public String getCompetenceHistorique() {
        return competenceHistorique;
    }

    public void setCompetenceHistorique(String competenceHistorique) {
        this.competenceHistorique = competenceHistorique;
    }

    public String getOutilHistorique() {
        return outilHistorique;
    }

    public void setOutilHistorique(String outilHistorique) {
        this.outilHistorique = outilHistorique;
    }

    public String getLangueHistorique() {
        return langueHistorique;
    }

    public void setLangueHistorique(String langueHistorique) {
        this.langueHistorique = langueHistorique;
    }

    public String getEquipementHistorique() {
        return equipementHistorique;
    }

    public void setEquipementHistorique(String equipementHistorique) {
        this.equipementHistorique = equipementHistorique;
    }

    public String getNomCapaciteHistorique() {
        return nomCapaciteHistorique;
    }

    public void setNomCapaciteHistorique(String nomCapaciteHistorique) {
        this.nomCapaciteHistorique = nomCapaciteHistorique;
    }

    public String getCapaciteHistorique() {
        return capaciteHistorique;
    }

    public void setCapaciteHistorique(String capaciteHistorique) {
        this.capaciteHistorique = capaciteHistorique;
    }
}
