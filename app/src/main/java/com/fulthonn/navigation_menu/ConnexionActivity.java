package com.fulthonn.navigation_menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fulthonn.model.Personne;

public class ConnexionActivity extends AppCompatActivity {
    private Button connexion;
    private Button creerCompte;
    private EditText login;
    private EditText password;
    //private String username;
    //private String motDePass;
   private Personne admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        connexion=(Button)findViewById(R.id.btn_login_connexion);
        creerCompte=(Button) findViewById(R.id.btn_creer_compte_connexion);
        login= (EditText) findViewById(R.id.editText_userName_connexion);
        password=(EditText)findViewById(R.id.editText_motdePass_connexion);
        //username=login.getText().toString();
        //motDePass=password.getText().toString();

        admin =new Personne("Fulthonn","admin@carmaint.net","admin");
        //admin.setEmail("admin@carmaint.net");
        //admin.setPassword("admin");


        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context= getApplicationContext();
                final String username=login.getText().toString();
                final String motDePass=password.getText().toString();

                if(!admin.getEmail().equalsIgnoreCase(username)  && !admin.getPassword().equalsIgnoreCase(motDePass))
               {
                    Intent intent =new Intent(ConnexionActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(context,"emain: admin@carmaint.net and password: admin",Toast.LENGTH_LONG).show();
                }



            }
        });
    }

}
