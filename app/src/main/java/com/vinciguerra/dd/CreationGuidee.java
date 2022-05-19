package com.vinciguerra.dd;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class CreationGuidee extends AppCompatActivity {
    protected String  dragon = "Dragon";
    protected int etape;

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
                if (etape == 1){
                    String race = parentView.getItemAtPosition(position).toString();
                    if (!race.equals("")){
                        RaceManager.getRace(race, getBaseContext(), selectedItemView);
                        TextView titreCarac = (TextView) findViewById(R.id.textViewTitreCarac);
                        titreCarac.setText("Amélioration de caractéristique");
                        TextView carac = (TextView) findViewById(R.id.textViewCarac);
                        carac.setText(RaceManager.joueur.getCarac());
                        carac.setMovementMethod(new ScrollingMovementMethod());
                    }
                    Log.d("Dragon", "onItemSelected: "+ spinnerRace.getSelectedItem().toString());
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
    public void etapeSuivant (View v){
        Log.d(dragon, "etapeSuivant: "+ etape);
        TextView text = (TextView) findViewById(R.id.textViewName);
        switch (etape){
            case 0 :
                // Pour passer du prénom à la race
                EditText name = (EditText) findViewById(R.id.editTextPersonName);
                String name2 = name.getText().toString();
                if (name2.length()< 4){
                    Toast.makeText(getBaseContext(), "Le nom de votre personnage n'est pas assez long ou vide ",Toast.LENGTH_SHORT).show();
                }else{
                    text.setText(getText(R.string.choixRace));
                    name.setVisibility(View.GONE);
                    Spinner race = (Spinner) findViewById(R.id.spinnerRace);
                    race.setVisibility(View.VISIBLE);
                    Button annuler = (Button) findViewById(R.id.buttonAnnuler);
                    annuler.setText(getText(R.string.annuler));
                    etape = 1;
                    Log.d(dragon, "etapeSuivantCase 0: fini");
                }
                break;
            case 1 :
                // Pour passer de la race à la sous race (si cela est possible)
                break;
        }

    }

    /*
    * Permet de revenir en arrière lors de la création de personnage
    * @arugment View
    * @return void
    */
    public void etapePrecedente (View v){
        Log.d(dragon, "etapePrecedente: "+ etape);
        TextView text = (TextView) findViewById(R.id.textViewName);
        switch (etape){
            case 0:
                // retour à l'accueil
                finish();
                break;
            case 1:
                // Retour sur le nom du personnage
                text.setText(getText(R.string.nomPerso));
                EditText name = (EditText) findViewById(R.id.editTextPersonName);
                name.setVisibility(View.VISIBLE);
                Spinner race = (Spinner) findViewById(R.id.spinnerRace);
                race.setVisibility(View.GONE);
                Button annuler = (Button) findViewById(R.id.buttonAnnuler);
                annuler.setText(getText(R.string.accueil));
//                TextView textpres = (TextView) findViewById(R.id.textViewPresentation);
//                textpres.setText(getText(R.string.pres));
                etape = 0;
                Log.d(dragon, "etapePrecedentCase 1: "+ etape);
                break;
        }
    }

    public ArrayList<String> chargerList (Map<String,String> map){
        ArrayList<String> liste_de_string = new ArrayList <String> (RaceManager.getListRace(getBaseContext()).keySet());
        liste_de_string.add("");
        Collections.sort(liste_de_string);
        return liste_de_string;
    }

    public void chargerSpinner(int idView, Map<String,String> map){
        final Spinner spinner = (Spinner) findViewById(idView);
        final ArrayList<String> liste_de_string = chargerList(map);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, liste_de_string);
        spinner.setAdapter(adapter);
    }

}
