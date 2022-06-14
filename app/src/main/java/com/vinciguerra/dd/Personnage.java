package com.vinciguerra.dd;

import static com.vinciguerra.dd.modele.PersonnageManager.getClassePersonnage;
import static com.vinciguerra.dd.modele.PersonnageManager.getHistoriquePersonnage;
import static com.vinciguerra.dd.modele.PersonnageManager.getRacePersonnage;
import static com.vinciguerra.dd.modele.PersonnageManager.getSousEspecePersonnage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.vinciguerra.dd.modele.PersonnageManager;
import com.vinciguerra.dd.modele.RaceManager;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Personnage extends AppCompatActivity {
    public String pseudojoueur = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnage);
        chargerSpinner(R.id.spinnerPseudo, PersonnageManager.getListPseudo(getBaseContext()));
        Spinner spinnerPseudo = (Spinner) findViewById(R.id.spinnerPseudo);
        Spinner spinnerPersonnage = (Spinner) findViewById(R.id.spinnerPersonnage);
        spinnerPseudo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String pseudo = parentView.getItemAtPosition(position).toString();
                TextView votrePersonnage = (TextView) findViewById(R.id.textViewVotrePersonnage);
                if (!pseudo.equals("")){
                    pseudojoueur = pseudo;
                    spinnerPersonnage.setVisibility(View.VISIBLE);
                    votrePersonnage.setVisibility(View.VISIBLE);
                    chargerSpinner(R.id.spinnerPersonnage, PersonnageManager.getListPersonnage(getBaseContext(), pseudo));
                }else {
                    clearscroll(selectedItemView);
                    spinnerPersonnage.setVisibility(View.INVISIBLE);
                    votrePersonnage.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spinnerPersonnage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView titreNom = (TextView) findViewById(R.id.textViewTitreNom);
                TextView nom = (TextView) findViewById(R.id.textViewNom);
                TextView titreRace = (TextView) findViewById(R.id.textViewTitreRace);
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
                TextView titreClasse = (TextView) findViewById(R.id.textViewTitreClasse);
                TextView classe = (TextView) findViewById(R.id.textViewClasse);
                TextView titreHistorique = (TextView) findViewById(R.id.textViewTitreHistorique);
                TextView historique = (TextView) findViewById(R.id.textViewHistorique);
                clearscroll(selectedItemView);
                String personnage = parentView.getItemAtPosition(position).toString();

                if (!personnage.equals("")){
                    titreNom.setVisibility(View.VISIBLE);
                    nom.setText(personnage);
                    String racePersonnage = getRacePersonnage(getBaseContext(), personnage, pseudojoueur);
                    String sousEspecePersonnage = getSousEspecePersonnage(getBaseContext(), personnage, pseudojoueur);
                    String classePersonnage = getClassePersonnage(getBaseContext(), personnage, pseudojoueur);
                    String historiquePersonnage = getHistoriquePersonnage(getBaseContext(), personnage, pseudojoueur);
                    titreRace.setVisibility(View.VISIBLE);
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
                        titreSousEspece.setVisibility(View.VISIBLE);
                    }else {
                        titreSousEspece.setVisibility(View.GONE);
                        sousEspece.setVisibility(View.GONE);
                    }
                    titreClasse.setVisibility(View.VISIBLE);
                    classe.setText(classePersonnage);
                    titreHistorique.setVisibility(View.VISIBLE);
                    historique.setText(historiquePersonnage);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                TextView text = (TextView) findViewById(R.id.textViewPresentation);
                text.setText(getText(R.string.pres));
            }
        });
    }

    public ArrayList<String> chargerList(Map<String, String> map) {
        ArrayList<String> liste_de_string = new ArrayList<String>(map.keySet());
        liste_de_string.add("");
        Collections.sort(liste_de_string);
        return liste_de_string;
    }

    public void chargerSpinner(int idView, Map<String, String> map) {
        final Spinner spinner = (Spinner) findViewById(idView);
        final ArrayList<String> liste_de_string = chargerList(map);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, liste_de_string);
        spinner.setAdapter(adapter);
    }

    public void clearscroll (View v){
        TextView titreNom = (TextView) findViewById(R.id.textViewTitreNom);
        TextView nom = (TextView) findViewById(R.id.textViewNom);
        TextView titreRace = (TextView) findViewById(R.id.textViewTitreRace);
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
        TextView titreClasse = (TextView) findViewById(R.id.textViewTitreClasse);
        TextView classe = (TextView) findViewById(R.id.textViewClasse);
        TextView titreHistorique = (TextView) findViewById(R.id.textViewTitreHistorique);
        TextView historique = (TextView) findViewById(R.id.textViewHistorique);
        titreNom.setVisibility(View.INVISIBLE);
        nom.setText("");
        titreRace.setVisibility(View.INVISIBLE);
        race.setText("");
        titreTrait1.setText("");
        trait1.setText("");
        titreTrait2.setText("");
        trait2.setText("");
        titreTrait3.setText("");
        trait3.setText("");
        titreTrait4.setText("");
        trait4.setText("");
        sousEspece.setText("");
        titreSousEspece.setVisibility(View.INVISIBLE);
        titreClasse.setVisibility(View.INVISIBLE);
        classe.setText("");
        titreHistorique.setVisibility(View.INVISIBLE);
        historique.setText("");
    }

    public void retour (View v){
        finish();
    }
}
