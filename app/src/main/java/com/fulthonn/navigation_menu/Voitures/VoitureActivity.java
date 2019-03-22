package com.fulthonn.navigation_menu.Voitures;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Voiture;
import com.fulthonn.navigation_menu.DetailVoitureActivity;
import com.fulthonn.navigation_menu.R;
import com.fulthonn.navigation_menu.adapters.VoitureAdapter;

import java.util.ArrayList;

public class VoitureActivity extends AppCompatActivity  {

    RecyclerView rv;
    VoitureAdapter adapter;

    ArrayList<Voiture> myVoitures;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_voiture);
        Context context = getApplicationContext();
        this.rv = findViewById(R.id.rv_samples);

        initDatas();

        this.adapter = new VoitureAdapter(this.myVoitures);
        this.rv.setLayoutManager(new LinearLayoutManager(context));
        this.rv.setAdapter(this.adapter);

        this.adapter.setOnItemClickListener(new VoitureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Voiture voiture) {
                Intent intentDetail=new Intent(VoitureActivity.this, DetailVoitureActivity.class);
                intentDetail.putExtra("IMAGE_KEY",voiture.getPhoto());
                intentDetail.putExtra("MATRICULE_KEY",getResources().getString(R.string.matricule).toUpperCase()+voiture.getMatricule());
                intentDetail.putExtra("MARQUE_KEY",getResources().getString(R.string.marque).toUpperCase()+voiture.getMarque());
                intentDetail.putExtra("MODELE_KEY",getResources().getString(R.string.modele).toUpperCase()+voiture.getModele());
                intentDetail.putExtra("MISE_EN_SERVICE_KEY",getResources().getString(R.string.mise_en_service).toUpperCase()+voiture.getMiseEnService());
                intentDetail.putExtra("VITESSE_MAX_KEY",getResources().getString(R.string.vitesse_max).toUpperCase()+voiture.getVitesseMax());
                intentDetail.putExtra("STATUT_KEY",getResources().getString(R.string.statut).toUpperCase()+voiture.getStatut());
                startActivity(intentDetail);
                Toast.makeText(getApplicationContext(), "Vous avez cliqué sur"+voiture.getMatricule(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void initDatas(){
        LocalBd.initDatas();
        this.myVoitures = LocalBd.myVoitures;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_samples, menu);

        MenuItem searchItem = menu.findItem(R.id.search_id);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}
