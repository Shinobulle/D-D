package com.vinciguerra.dd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vinciguerra.dd.modele.ClasseManager;
import com.vinciguerra.dd.modele.ConnexionSQLite;
import com.vinciguerra.dd.modele.HistoriqueManager;
import com.vinciguerra.dd.modele.RaceManager;

public class ValidationPersonnage extends AppCompatActivity {
    private static final String TAG = "Dragon";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_personnage);
        Intent personnage = getIntent();
        String nomPersonnage = personnage.getStringExtra("nomPersonnage");
        String racePersonnage = personnage.getStringExtra("racePersonnage");
        String sousEspecePersonnage = personnage.getStringExtra("sousEspecePersonnage");
        String classePersonnage = personnage.getStringExtra("classePersonnage");
        String historiquePersonnage = personnage.getStringExtra("historiquePersonnage");
        ConnexionSQLite connexion = new ConnexionSQLite(ValidationPersonnage.this,"DandD", null, 1 );
        connexion.ajoutNouveauPersonnage(nomPersonnage, racePersonnage,
                sousEspecePersonnage, classePersonnage, historiquePersonnage);

        TextView nom = (TextView) findViewById(R.id.textViewNom);
        TextView race = (TextView) findViewById(R.id.textViewRace);
        TextView titreTrait1 = (TextView) findViewById(R.id.textViewTitreTrait1);
        TextView trait1 = (TextView) findViewById(R.id.textViewTrait1);
        TextView titreTrait2 = (TextView) findViewById(R.id.textViewTitreTrait2);
        TextView trait2 = (TextView) findViewById(R.id.textViewTrait2);
        TextView titreTrait3 = (TextView) findViewById(R.id.textViewTitreTrait3);
        TextView trait3 = (TextView) findViewById(R.id.textViewTrait3);
        TextView titreTrait4 = (TextView) findViewById(R.id.textViewTitreTrait4);
        TextView trait4 = (TextView) findViewById(R.id.textViewTrait4);
        TextView titreSousEspece = (TextView) findViewById(R.id.textViewTitreSousEspece);
        TextView sousEspece = (TextView) findViewById(R.id.textViewSousEspece);
        TextView classe = (TextView) findViewById(R.id.textViewClasse);
        TextView historique = (TextView) findViewById(R.id.textViewHistorique);

        nom.setText(nomPersonnage);
        race.setText(racePersonnage);
        RaceManager.getRace(racePersonnage, getBaseContext());
        titreTrait1.setText(RaceManager.joueur.getTitreTrait1());
        trait1.setText(RaceManager.joueur.getTrait1());
        titreTrait2.setText(RaceManager.joueur.getTitreTrait2());
        trait2.setText(RaceManager.joueur.getTrait2());
        titreTrait3.setText(RaceManager.joueur.getTitreTrait3());
        trait3.setText(RaceManager.joueur.getTrait3());
        if (!(RaceManager.joueur.getTrait4()).equals("")){
            titreTrait4.setText(RaceManager.joueur.getTitreTrait4());
            trait4.setText(RaceManager.joueur.getTrait4());
        }else {
            titreTrait4.setVisibility(View.GONE);
            trait4.setVisibility(View.GONE);
        }
        if (!sousEspecePersonnage.equals("")){
            if (!racePersonnage.equals("Drakéide")){
                titreSousEspece.setText(R.string.validationSousEspece);

            }else {
                titreSousEspece.setText(R.string.validationCouleur);

            }
            sousEspece.setText(sousEspecePersonnage);
        }else {
            titreSousEspece.setVisibility(View.GONE);
            sousEspece.setVisibility(View.GONE);
        }
        classe.setText(classePersonnage);
        historique.setText(historiquePersonnage);
    }

    public void retourAccueil (View v){
        startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
