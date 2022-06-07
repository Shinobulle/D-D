package com.vinciguerra.dd.races;

import android.content.Context;
import android.content.res.Resources;

import com.vinciguerra.dd.R;

public abstract class Race {
    private String espece;
    private String carac;
    private String age;
    private String taille;
    private String vitesse;
    private String trait1;
    private String trait2;
    private String trait3;
    private String trait4;
    private String langues;
    private String titreTrait1;
    private String titreTrait2;
    private String titreTrait3;
    private String titreTrait4;

    public abstract void setInfo(Context context, String race, int drkCarac,
                                 int drkAge, int drkTaille, int vitesse,
                                 int drkTrait1, int drkTrait2, int drkTrait3,
                                 int drkTrait4, int drkLangue, int titreTrait1,
                                 int titreTrait2, int titreTrait3, int titreTrait4);


    // Définir espece
    public void setEspece(String espece){
        this.espece = espece;
    }

    public String getEspece() {
        return espece;
    }

    // Son ou ses caractéristiques
    public void setCarac(String carac) {
        this.carac = carac;
    }

    public String getCarac() {
        return carac;
    }

    // Définir son age
    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    // Définir sa taille
    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getTaille() {
        return taille;
    }

    // Définir sa vitesse
    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }

    public String getVitesse() {
        return vitesse;
    }

    //Définir ses traits liées à la race
    public void setTrait1(String trait1) {
        this.trait1 = trait1;
    }

    public String getTrait1() {
        return trait1;
    }

    public void setTrait2(String trait2) {
        this.trait2 = trait2;
    }

    public String getTrait2() {
        return trait2;
    }

    public void setTrait3(String trait3) {
        this.trait3 = trait3;
    }

    public String getTrait3() {
        return trait3;
    }

    public void setTrait4(String trait4) {
        this.trait4 = trait4;
    }

    public String getTrait4() {
        return trait4;
    }
    // Définir la ou les langues connue
    public void setLangues(String langues) {
        this.langues = langues;
    }

    public String getLangues() {
        return langues;
    }

    public void setTitreTrait1(String titreTrait1) {
        this.titreTrait1 = titreTrait1;
    }

    public String getTitreTrait1() {
        return titreTrait1;
    }

    public void setTitreTrait2(String titreTrait2) {
        this.titreTrait2 = titreTrait2;
    }

    public String getTitreTrait2() {
        return titreTrait2;
    }
    public void setTitreTrait3(String titreTrait3) {
        this.titreTrait3 = titreTrait3;
    }

    public String getTitreTrait3() {
        return titreTrait3;
    }
    public void setTitreTrait4(String titreTrait4) {
        this.titreTrait4 = titreTrait4;
    }

    public String getTitreTrait4() {
        return titreTrait4;
    }

}
