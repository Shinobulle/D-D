package com.vinciguerra.dd;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vinciguerra.dd.modele.RaceManager;
import com.vinciguerra.dd.races.Race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CreationGuidee extends AppCompatActivity {
    protected String dragon = "Dragon";
    protected int etape;
    public String personnage;
    public String nomPersonnage;
    public String racePersonnage = "";
    public String sousEspecePersonnage ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guided_creation);
        etape = 0;
        ImageView dragon = (ImageView) findViewById(R.id.imageViewDragon);
        chargerSpinner(R.id.spinnerRace, RaceManager.getListRace(getBaseContext()));
        dragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "CHRCHR", Toast.LENGTH_SHORT).show();
            }
        });
        Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerRace);
        spinnerRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView text = (TextView) findViewById(R.id.textViewPresentation);
                TextView titreCarac = (TextView) findViewById(R.id.textViewTitreCarac);
                TextView carac = (TextView) findViewById(R.id.textViewCarac);
                TextView titreAge = (TextView) findViewById(R.id.textViewTitreAge);
                TextView age = (TextView) findViewById(R.id.textViewAge);
                TextView titreTaille = (TextView) findViewById(R.id.textViewTitreTaille);
                TextView taille = (TextView) findViewById(R.id.textViewTaille);
                TextView titreVitesse = (TextView) findViewById(R.id.textViewTitreSpeed);
                TextView vitesse = (TextView) findViewById(R.id.textViewSpeed);
                TextView titreTrait1 = (TextView) findViewById(R.id.textViewTitreTrait1);
                TextView trait1 = (TextView) findViewById(R.id.textViewTrait1);
                TextView titreTrait2 = (TextView) findViewById(R.id.textViewTitreTrait2);
                TextView trait2 = (TextView) findViewById(R.id.textViewTrait2);
                TextView titreTrait3 = (TextView) findViewById(R.id.textViewTitreTrait3);
                TextView trait3 = (TextView) findViewById(R.id.textViewTrait3);
                TextView titreTrait4 = (TextView) findViewById(R.id.textViewTitreTrait4);
                TextView trait4 = (TextView) findViewById(R.id.textViewTrait4);
                TextView titreLangue = (TextView) findViewById(R.id.textViewTitreLangues);
                TextView langue = (TextView) findViewById(R.id.textViewLangue);

                if (etape == 1) {
                    String race = parentView.getItemAtPosition(position).toString();
                    if (!race.equals("")) {
                        RaceManager.getRace(race, getBaseContext(), selectedItemView);
                        titreCarac.setText(R.string.carac);
                        carac.setText(RaceManager.joueur.getCarac());
                        titreAge.setText(R.string.titreAge);
                        titreTaille.setText(R.string.titreTaille);
                        taille.setText(RaceManager.joueur.getTaille());
                        age.setText(RaceManager.joueur.getAge());
                        titreVitesse.setText(R.string.titreVitesse);
                        vitesse.setText(RaceManager.joueur.getVitesse());
                        titreTrait1.setText(RaceManager.joueur.getTitreTrait1());
                        trait1.setText(RaceManager.joueur.getTrait1());
                        titreTrait2.setText(RaceManager.joueur.getTitreTrait2());
                        trait2.setText(RaceManager.joueur.getTrait2());
                        titreTrait3.setText(RaceManager.joueur.getTitreTrait3());
                        trait3.setText(RaceManager.joueur.getTrait3());

                        if (RaceManager.joueur.getEspece().equals("Drakéide")) {
                            titreTrait4.setText(R.string.titrelangue);
                            trait4.setText(RaceManager.joueur.getLangues());
                        } else {
                            titreTrait4.setText(RaceManager.joueur.getTitreTrait4());
                            trait4.setText(RaceManager.joueur.getTrait4());
                            titreLangue.setText(R.string.titrelangue);
                            langue.setText(RaceManager.joueur.getLangues());
                        }
                        racePersonnage = RaceManager.joueur.getEspece();
                    } else {
                        titreCarac.setText("");
                        carac.setText("");
                        titreAge.setText("");
                        titreTaille.setText("");
                        taille.setText("");
                        age.setText("");
                        titreVitesse.setText("");
                        vitesse.setText("");
                        titreTrait1.setText("");
                        trait1.setText("");
                        titreTrait2.setText("");
                        trait2.setText("");
                        titreTrait3.setText("");
                        trait3.setText("");
                        titreTrait4.setText("");
                        trait4.setText("");
                        titreLangue.setText("");
                        langue.setText("");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                TextView text = (TextView) findViewById(R.id.textViewPresentation);
                text.setText(getText(R.string.pres));
            }
        });
    }

    /*
     * Permet d'avancer dans la création de son personnage
     * @argument View
     * @return void
     */
    public void etapeSuivant(View v) {
        Log.d(dragon, "etapeSuivant: " + etape);
        TextView text = (TextView) findViewById(R.id.textViewName);
        Button annuler = (Button) findViewById(R.id.buttonAnnuler);
        TextView textpres = (TextView) findViewById(R.id.textViewPresentation);
        Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerRace);
        String raceChoisi = (spinnerRace).getSelectedItem().toString();

        switch (etape) {
            case 0:
                // Pour passer du prénom à la race
                EditText name = (EditText) findViewById(R.id.editTextPersonName);
                String name2 = name.getText().toString();
                if (name2.length() < 4) {
                    Toast.makeText(getBaseContext(), "Le nom de votre personnage n'est pas assez long ou vide ", Toast.LENGTH_SHORT).show();
                } else {
                    closeKeyboard();
                    text.setText(getText(R.string.choixRace));
                    name.setVisibility(View.GONE);
                    nomPersonnage = name2;
                    personnage = "Nom du personnage : " + name2 + "\n";
                    textpres.setText(personnage);
                    spinnerRace.setVisibility(View.VISIBLE);
                    annuler.setText(getText(R.string.annuler));
                    etape = 1;
                    Log.d(dragon, "etapeSuivantCase 0: fini");
                }
                break;
            case 1:
                if (!racePersonnage.equals("")) {
                    Log.d(dragon, "etapeSuivanteCase 1: " + etape);
                    personnage = (textpres.getText().toString()) + "La race : " + raceChoisi + "\n";
                    textpres.setText(personnage);
                    clearscroll(v);
                    if (raceChoisi.equals("Elfe")||raceChoisi.equals("Halfelin")||raceChoisi.equals("Nain")||raceChoisi.equals("Gnome")||raceChoisi.equals("Drakéide")){
                        etape = 2;
                        afficherSousEspece(v, raceChoisi);
                        if (raceChoisi.equals("Drakéide")){
                            text.setText(getText(R.string.choixCouleur));
                        }else{
                            text.setText(getText(R.string.sousEspece));
                        }
                    }
                    else{
                        etape = 3;
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Ce n'est pas une race !", Toast.LENGTH_SHORT).show();
                }
                Log.d(dragon, "etapeSuivanteCase : " + etape +" fini");
                break;
            case 2:
                if (!raceChoisi.equals("")){
                    clearscroll(v);
                    if (raceChoisi.equals("Drakéide")){
                        personnage = (textpres.getText().toString()) + "La couleur : " + raceChoisi+ "\n";

                    }else{
                        personnage = (textpres.getText().toString()) + "La couleur : " + raceChoisi + "\n";
                    }
                    sousEspecePersonnage = raceChoisi;
                    textpres.setText(personnage);
                    spinnerRace.setVisibility(View.GONE);
                    text.setText(getText(R.string.classe));
                    etape = 3;
                }else{
                    Toast.makeText(getBaseContext(), "Erreur, selectionnez votre sous-espèce ou votre couleur de dragon !", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    /*
     * Permet de revenir en arrière lors de la création de personnage
     * @arugment View
     * @return void
     */
    public void etapePrecedente(View v) {
        Log.d(dragon, "etapePrecedente: " + etape);
        TextView text = (TextView) findViewById(R.id.textViewName);
        Button annuler = (Button) findViewById(R.id.buttonAnnuler);
        TextView textpres = (TextView) findViewById(R.id.textViewPresentation);
        EditText name = (EditText) findViewById(R.id.editTextPersonName);
        Spinner spinnerRace = (Spinner) findViewById(R.id.spinnerRace);

        switch (etape) {
            case 0:
                // retour à l'accueil
                finish();
                break;
            case 1:
                // Retour sur le nom du personnage
                text.setText(getText(R.string.nomPerso));
                name.setVisibility(View.VISIBLE);
                spinnerRace.setVisibility(View.GONE);
                annuler.setText(getText(R.string.accueil));
                textpres.setText(getText(R.string.pres));
                clearscroll(v);
                etape = 0;
                Log.d(dragon, "etapePrecedentCase : " + etape);
                break;
            case 2:
                personnage = "Nom du personnage : " + nomPersonnage + "\n";
                textpres.setText(personnage);
                text.setText(getText(R.string.choixRace));
                etape = 1;
                chargerSpinner(R.id.spinnerRace, RaceManager.getListRace(getBaseContext()));
                racePersonnage = "";
                Log.d(dragon, "etapePrecedentCase : " + etape);
                break;
            case 3 :
                personnage = "Nom du personnage : " + nomPersonnage + "\n"
                        + "la race : "+ racePersonnage;
                textpres.setText(personnage);
                spinnerRace.setVisibility(View.VISIBLE);
                afficherSousEspece(v, racePersonnage);
                text.setText(getText(R.string.sousEspece));
                etape=2;
                break;
        }
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

    private void closeKeyboard() {
        // this will give us the view
        // which is currently focus
        // in this layout
        View view = this.getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }

    }

    public void afficherSousEspece (View v, String raceChoisi){
        TextView titreCarac = (TextView) findViewById(R.id.textViewTitreCarac);
        TextView carac = (TextView) findViewById(R.id.textViewCarac);
        switch (raceChoisi){
            case "Drakéide" :
                StringBuilder typeDragon = new StringBuilder();
                StringBuilder typeDegat = new StringBuilder();
                Map <String,String> couleurDragon = RaceManager.joueur.getSousEspece();
                for (String key : couleurDragon.keySet()){
                    typeDragon.append(key).append("\n");
                    typeDegat.append(couleurDragon.get(key)).append("\n");
                }
                titreCarac.setText(typeDragon);
                carac.setText(typeDegat);
                chargerSpinner(R.id.spinnerRace, RaceManager.joueur.getSousEspece());
                break;
            case "Elfe" :
        }
    }

    public void clearscroll (View v){
        TextView text = (TextView) findViewById(R.id.textViewPresentation);
        TextView titreCarac = (TextView) findViewById(R.id.textViewTitreCarac);
        TextView carac = (TextView) findViewById(R.id.textViewCarac);
        TextView titreAge = (TextView) findViewById(R.id.textViewTitreAge);
        TextView age = (TextView) findViewById(R.id.textViewAge);
        TextView titreTaille = (TextView) findViewById(R.id.textViewTitreTaille);
        TextView taille = (TextView) findViewById(R.id.textViewTaille);
        TextView titreVitesse = (TextView) findViewById(R.id.textViewTitreSpeed);
        TextView vitesse = (TextView) findViewById(R.id.textViewSpeed);
        TextView titreTrait1 = (TextView) findViewById(R.id.textViewTitreTrait1);
        TextView trait1 = (TextView) findViewById(R.id.textViewTrait1);
        TextView titreTrait2 = (TextView) findViewById(R.id.textViewTitreTrait2);
        TextView trait2 = (TextView) findViewById(R.id.textViewTrait2);
        TextView titreTrait3 = (TextView) findViewById(R.id.textViewTitreTrait3);
        TextView trait3 = (TextView) findViewById(R.id.textViewTrait3);
        TextView titreTrait4 = (TextView) findViewById(R.id.textViewTitreTrait4);
        TextView trait4 = (TextView) findViewById(R.id.textViewTrait4);
        TextView titreLangue = (TextView) findViewById(R.id.textViewTitreLangues);
        TextView langue = (TextView) findViewById(R.id.textViewLangue);
        titreCarac.setText("");
        carac.setText("");
        titreAge.setText("");
        titreTaille.setText("");
        taille.setText("");
        age.setText("");
        titreVitesse.setText("");
        vitesse.setText("");
        titreTrait1.setText("");
        trait1.setText("");
        titreTrait2.setText("");
        trait2.setText("");
        titreTrait3.setText("");
        trait3.setText("");
        titreTrait4.setText("");
        trait4.setText("");
        titreLangue.setText("");
        langue.setText("");
    }
}
