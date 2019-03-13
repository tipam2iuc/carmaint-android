package com.fulthonn.navigation_menu;

import android.content.Context;
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

import com.fulthonn.model.Sample;
import com.fulthonn.navigation_menu.adapters.VoitureAdapter;

import java.util.ArrayList;

public class SampleActivity extends AppCompatActivity  {

    RecyclerView rv;
    VoitureAdapter adapter;

    ArrayList<Sample> mySamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);
        Context context = getApplicationContext();
        this.rv = findViewById(R.id.rv_samples);

        initDatas();

        this.adapter = new VoitureAdapter(this.mySamples);
        this.rv.setLayoutManager(new LinearLayoutManager(context));
        this.rv.setAdapter(this.adapter);

        this.adapter.setOnItemClickListener(new VoitureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sample sample) {
                Toast.makeText(getApplicationContext(), sample.getmText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void initDatas(){
        this.mySamples = new ArrayList<>();

        this.mySamples.add(new Sample("Mercedez", null));
        this.mySamples.add(new Sample("Toyota", null));
        this.mySamples.add(new Sample("LandRover", null));
        this.mySamples.add(new Sample("RangRover", null));
        this.mySamples.add(new Sample("Renauld", null));
        this.mySamples.add(new Sample("Peugeo", null));
        this.mySamples.add(new Sample("Ferrari", null));
        this.mySamples.add(new Sample("Rav4", null));
        this.mySamples.add(new Sample("Hummer", null));
        this.mySamples.add(new Sample("Prado", null));
        this.mySamples.add(new Sample("Izizu", null));
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
