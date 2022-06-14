package com.vinciguerra.dd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView dragon = (ImageView) findViewById(R.id.imageViewDragon);
        dragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "CHRCHR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    * Permet d'aller vers l'activité CreationGuidee
    */
    public void guidedCreation  (View v)
    {
        Intent guided = new Intent(this, CreationGuidee.class);
        startActivity(guided);
    }

    /*
     * Permet d'aller vers l'activité Personnage
     */
    public void fichePersonnages (View v ){
        Intent fiche = new Intent(this, Personnage.class);
        startActivity(fiche);
    }
}