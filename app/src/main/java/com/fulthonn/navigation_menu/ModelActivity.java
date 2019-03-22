package com.fulthonn.navigation_menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Model;
import com.fulthonn.model.Voiture;
import com.fulthonn.navigation_menu.Voitures.VoitureActivity;
import com.fulthonn.navigation_menu.adapters.ModelAdapter;
import com.fulthonn.navigation_menu.adapters.VoitureAdapter;

import java.util.ArrayList;

public class ModelActivity extends AppCompatActivity {
    RecyclerView rv;
    ModelAdapter adapter;
    ArrayList<Model> myModels;
    ArrayList<Model> temps;
    String model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        Context context = getApplicationContext();
        Intent i= getIntent();
        model=i.getExtras().getString("MODEL_KEY");
        this.rv = findViewById(R.id.rv_model);
        Toast.makeText(ModelActivity.this,model,Toast.LENGTH_SHORT).show();
        myModels=initDatas();

        this.adapter = new ModelAdapter(this.myModels);
        this.rv.setLayoutManager(new GridLayoutManager(context,2));
        this.rv.setAdapter(this.adapter);

        adapter.setOnItemClickListener(new ModelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Model model) {
                Intent intentVoitures = new Intent(getApplicationContext(), VoitureActivity.class);
                intentVoitures.putExtra("CATEGORIE_KEY",model.getCategorie());
                startActivity(intentVoitures);
                Toast.makeText(getApplicationContext(), "Vous avez cliqué sur "+model.getNomModel(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    ArrayList<Model> initDatas(){

        temps= LocalBd.initModelDatas();
        ArrayList<Model> res=new ArrayList<Model>();
        for (Model modele :temps){

            if(modele.getCategorie().equalsIgnoreCase(model) ){
                res.add(modele);
            }
        }
        return res;

    }
}
