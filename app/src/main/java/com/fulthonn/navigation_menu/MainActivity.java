package com.fulthonn.navigation_menu;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout mdraDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mdraDrawerLayout= (DrawerLayout)findViewById(R.id.nav_id_drawer);
        mActionBarDrawerToggle=new ActionBarDrawerToggle(this,mdraDrawerLayout,R.string.open,R.string.close);
        mdraDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        NavigationView navigationView=findViewById(R.id.nav_menu_id);
        navigationView.setNavigationItemSelectedListener(this);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
             new fragment_dashboard()).commit();
            navigationView.setCheckedItem(R.id.fragment_dashboard_id);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new fragment_dashboard()).commit();

                break;
            case R.id.nav_accident:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new fragment_accident()).commit();
                break;
            case R.id.nav_incident:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new fragment_incident()).commit();
                break;
            case R.id.nav_panne:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new fragment_pannes()).commit();
                break;
            case R.id.nav_entree_sortie:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new fragment_entree_sortie()).commit();
                break;
        }
        mdraDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
   }
}
