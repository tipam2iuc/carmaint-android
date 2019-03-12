package com.fulthonn.navigation_menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Personne;

import java.util.ArrayList;

public class CreerCompteActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private EditText retypePassword;
    private EditText email;
    private CheckBox checkBoxagree;
    private Button alreadyAMember;
    private Button signUp;
   // public final ArrayList<Personne> personnes= new ArrayList<>();
    public Personne user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);
        signUp= findViewById(R.id.btn_signUp);
        final Context context=getApplicationContext();
        userName=findViewById(R.id.editText_userName_CreerCompte);
        email=findViewById(R.id.editText_email_CreerCompte);
        password=findViewById(R.id.editText_password_CreerCompte);
        alreadyAMember=findViewById(R.id.btn_alreadyMember_creerCompte);
        retypePassword=findViewById(R.id.editText_retypePassword_CreerCompte);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxagree=findViewById(R.id.chkBox_agree_creerCompte);
                if(checkBoxagree.isChecked()&& userName.getText().toString()!=""&& password.getText().toString()!=""&& email.getText().toString()!="")
                {
                    if(password.getText().toString().equals(retypePassword.getText().toString()))
                    {
                        user=new Personne();
                        user.setPassword(password.getText().toString());
                        user.setEmail(email.getText().toString());
                        user.setFirsName(userName.getText().toString());
                        LocalBd.personnes.add(user);
                        Toast.makeText(context,"Compte créé avec succès",Toast.LENGTH_LONG);

                        Intent intent = new Intent(CreerCompteActivity.this,ConnexionActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });


        alreadyAMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CreerCompteActivity.this,ConnexionActivity.class);
                startActivity(intent);
            }
        });
    }
}
