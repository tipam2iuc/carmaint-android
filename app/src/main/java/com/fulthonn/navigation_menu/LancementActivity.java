package com.fulthonn.navigation_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LancementActivity extends AppCompatActivity {
    private Button connexion;
    private Button creerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancement);
        connexion=findViewById(R.id.btn_connexion_lancement);
        creerCompte=findViewById(R.id.btn_creercompte_lancement);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent lancementActivityIntent =new Intent(LancementActivity.this,);
            }
        });
    }


}
