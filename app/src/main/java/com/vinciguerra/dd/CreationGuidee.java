package com.vinciguerra.dd;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreationGuidee extends AppCompatActivity {
    protected String  dragon = "Dragon";
    protected int etape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guided_creation);
        etape = 0;
        ImageView dragon = (ImageView) findViewById(R.id.imageViewDragon);
        dragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "CHRCHR", Toast.LENGTH_SHORT).show();
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
                    Log.d(dragon, "etapeSuivantCase 0: "+ etape);
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
                etape = 0;
                Log.d(dragon, "etapePrecedentCase 1: "+ etape);
                break;
        }
    }



}
