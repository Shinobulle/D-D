package com.vinciguerra.dd.races;

import android.content.Context;
import android.content.res.Resources;

import com.vinciguerra.dd.R;

public class Drakeide extends Race{



    public void setInfo (Context context, String race, int carac, int age, int taille, int vitesse,
                         int trait1, int trait2, int trait3, int trait4, int langue,
                         int titreTrait1, int titreTrait2, int titreTrait3, int titreTrait4){
        Resources res = context.getResources();
        setEspece(race);
        setCarac(res.getString(carac));
        setAge(res.getString(age));
        setTaille(res.getString(taille));
        setVitesse(res.getString(vitesse));
        setTrait1(res.getString(trait1));
        setTrait2(res.getString(trait2));
        setTrait3(res.getString(trait3));
        setTrait4(res.getString(trait4));
        setLangues(res.getString(langue));
        setTitreTrait1(res.getString(titreTrait1));
        setTitreTrait2(res.getString(titreTrait2));
        setTitreTrait3(res.getString(titreTrait3));
        setTitreTrait4(res.getString(titreTrait4));
    }



}
