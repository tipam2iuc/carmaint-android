package com.fulthonn.navigation_menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.fulthonn.model.Categorie;
import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Model;
import com.fulthonn.navigation_menu.adapters.CategorieAdapter;
import com.fulthonn.navigation_menu.adapters.ModelAdapter;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rv;
    CategorieAdapter adapter;
    ArrayList<Categorie> myCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context=getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rv=findViewById(R.id.recycleView_marqueCode);

        initDatas();

        this.adapter = new CategorieAdapter(this.myCategories);
        this.rv.setLayoutManager(new GridLayoutManager(context,2));
        this.rv.setAdapter(this.adapter);
        adapter.setOnItemClickListener(new CategorieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Categorie categorie) {
                Intent intentModel= new Intent(CategoryActivity.this,ModelActivity.class);
                intentModel.putExtra("MODEL_KEY",categorie.getNomCategorie());
                startActivity(intentModel);
                Toast.makeText(context,"vous avez cliqué sur "+categorie.getNomCategorie(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    void initDatas(){
        LocalBd.initCategories();
        this.myCategories = LocalBd.myCategories;
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
