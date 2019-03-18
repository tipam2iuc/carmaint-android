package com.fulthonn.navigation_menu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fulthonn.ApiClient;
import com.fulthonn.ApiInterface;
import com.fulthonn.Personne2;
import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Personne;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InscriptionActivity extends AppCompatActivity {
    EditText firtName;
    EditText lastName;
    EditText cni;
    EditText email;
    EditText telephone;
    Spinner role;
    String roleString;
    Button inscrire;
    Button andreadyMember;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        firtName=findViewById(R.id.editText_userName_Inscription);
        lastName=findViewById(R.id.editText_LastName_Inscription);
        cni=findViewById(R.id.editText_Cni_Inscription);
        email=findViewById(R.id.editText_email_CreerCompte);
        telephone=findViewById(R.id.editText_telephone_Inscription);
        role=findViewById(R.id.editText_typeUser_Inscription);
        roleString=role.getSelectedItem().toString();
        inscrire=findViewById(R.id.btn_signUp);
        andreadyMember=findViewById(R.id.btn_alreadyMember_Inscription);

        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personne p = new Personne(1,cni.getText().toString(),firtName.getText().toString(),lastName.getText().toString(),null,roleString.toString(),null,email.getText().toString(),null,null,null,null);
                p.setLogin(roleString.toString()+"@"+"carmaint.net");
               // if(p!=null){
                  //  LocalBd.personnes.add(p);
               // }
                add_user(cni.getText().toString(),firtName.getText().toString(),lastName.getText().toString(),email.getText().toString(),roleString.toString());
            }
        });

    }
    public  void  add_user(String cni,String firtname,String lastname, String email ,String role)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        Call<Personne2> call=apiInterface.add_personne(cni,firtname,lastname,email,role);

        call.enqueue(new Callback<Personne2>() {
            @Override
            public void onResponse( @NonNull Call<Personne2> call, @NonNull Response<Personne2> response) {
                int s=response.body().getSuccess();
                String m=response.body().getMessage();
                if (m!="")
                {
                    if (s==1)
                    {
                        Toast.makeText(InscriptionActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(InscriptionActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Personne2> call, @NonNull Throwable t) {
                Toast.makeText(InscriptionActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }

}
