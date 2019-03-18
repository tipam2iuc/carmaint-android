package com.fulthonn.navigation_menu.Voitures;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.fulthonn.navigation_menu.R;
import com.fulthonn.navigation_menu.adapters.VoitureAdapter;

import java.util.ArrayList;

public class VoitureEnPanneActivity extends AppCompatActivity  {

    RecyclerView rv;
    VoitureAdapter adapter;

    ArrayList<Voiture> myVoitures;
    ArrayList<Voiture> myVoituresSample;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_voiture_enpanne);
        Context context = getApplicationContext();
        this.rv = findViewById(R.id.rv_voitureEnpanne);

        initDatas();

        this.adapter = new VoitureAdapter(this.myVoitures);
        this.rv.setLayoutManager(new LinearLayoutManager(context));
        this.rv.setAdapter(this.adapter);

        this.adapter.setOnItemClickListener(new VoitureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Voiture voiture) {
                Toast.makeText(getApplicationContext(), "Vous avez cliqué sur"+voiture.getMatricule(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void initDatas(){
        LocalBd.initDatas();
        LocalBd.initVoitureEnPanneDatas();
        this.myVoitures=LocalBd.myVoituresEnPanne;

       // myVoitures=LocalBd.myVoitures;



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_samples, menu);

        MenuItem searchItem = menu.findItem(R.id.search_id);
        SearchView searchView = (SearchView) searchItem.getActionView();

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
