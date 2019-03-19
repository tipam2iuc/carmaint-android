package com.fulthonn.navigation_menu;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulthonn.model.LocalBd;

public class DetailVoitureActivity extends AppCompatActivity {
    private ImageView imageDetail;
    private TextView matriculeDetail;
    private TextView marqueDetail;
    private TextView modelDetail;
    private TextView Detail;
    private TextView miseEnserviceDetail;
    private TextView vitesseMAXDetail;
    private TextView statutDetail;
    private TextView nombreTotalVoiture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voiture);
        imageDetail=findViewById(R.id.image_detail);
        matriculeDetail=findViewById(R.id.detail_matricule);
        marqueDetail=findViewById(R.id.detail_marque);
        modelDetail=findViewById(R.id.detail_modele);
        miseEnserviceDetail=findViewById(R.id.detail_MiseEnService);
        vitesseMAXDetail=findViewById(R.id.detail_Vitesse_max);
        statutDetail=findViewById(R.id.detail_status);


        //recupération des valeurs à partir de l'intent
        Intent i=getIntent();
        String image= i.getExtras().getString("IMAGE_KEY");
        String matricule= i.getExtras().getString("MATRICULE_KEY");
        String marque= i.getExtras().getString("MARQUE_KEY");
        String modele= i.getExtras().getString("MODELE_KEY");
        String miseEnService= i.getExtras().getString("MISE_EN_SERVICE_KEY");
        String vitesseMaxx= i.getExtras().getString("VITESSE_MAX_KEY");
        String statut= i.getExtras().getString("STATUT_KEY");
        //affectation des valeurs au champs
        imageDetail.setImageResource(R.drawable.mclaren);
        matriculeDetail.setText(matricule);
        marqueDetail.setText(marque);
        modelDetail.setText(modele);
        miseEnserviceDetail.setText(miseEnService);
        vitesseMAXDetail.setText(vitesseMaxx);
        statutDetail.setText(statut);


    }
}
