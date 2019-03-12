package com.fulthonn.navigation_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.fulthonn.model.Sample;
import com.fulthonn.navigation_menu.adapters.SampleAdapter;

import java.util.ArrayList;

public class SampleActivity extends AppCompatActivity implements SampleAdapter.SampleListener {

    RecyclerView rv;
    TextView tv_search_sample;
    SampleAdapter adapter;

    ArrayList<Sample> mySamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        this.rv = findViewById(R.id.rv_samples);
        this.tv_search_sample = findViewById(R.id.tv_search_sample);

        initDatas();

        this.adapter = new SampleAdapter(this.mySamples, this);


        this.rv.setAdapter(this.adapter);
    }

    void initDatas(){
        this.mySamples = new ArrayList<>();

        this.mySamples.add(new Sample("Freddy Kamgang", null));
        this.mySamples.add(new Sample("Freddy", null));
        this.mySamples.add(new Sample("Kamgang", null));
        this.mySamples.add(new Sample("Moi", null));
        this.mySamples.add(new Sample("Un jour là", null));
        this.mySamples.add(new Sample("Azertyuiop", null));
    }

    @Override
    public void onClick(Sample sample) {
        Toast.makeText(this, sample.getmText(), Toast.LENGTH_LONG);
    }
}
