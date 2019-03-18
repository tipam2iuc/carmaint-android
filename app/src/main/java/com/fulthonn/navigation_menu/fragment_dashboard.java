package com.fulthonn.navigation_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.time.Instant;
import java.util.Objects;

public class fragment_dashboard extends Fragment {

    BottomNavigationView bottomNav;
    Fragment homeFragment;
    Fragment notificationFragment;
    Fragment statFragment;
    FrameLayout frameLayout_dashboard;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Context context = getContext().getApplicationContext();
        final View view_dashboard = inflater.inflate(R.layout.fragment_dashboard, container, false);
       // final View view_home=inflater.inflate(R.layout.fragment_home,container,false);

       frameLayout_dashboard=view_dashboard.findViewById(R.id.id_frame_du_dashboard);

        //partie reservée au navigation bottom

        homeFragment= new HomeFragment();
        statFragment= new StatFragment();
        notificationFragment=new NotificationFragment();


        //démarrage Home  à l'ouverture
        setFragment(homeFragment);


        //fin du demarrage de home


        //récupération de l'Id de bottom navigation
        bottomNav = view_dashboard.findViewById(R.id.id_bottom_navigation);
        bottomNav.setBackgroundColor(getResources().getColor(R.color.yellow_primary));

        //listner sur les menu latérales
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.id_bot_nav_home:
                        bottomNav.setItemBackgroundResource(R.color.Bleu);
                        setFragment(homeFragment);
                        break;
                    case R.id.id_bot_nav_stat:
                        bottomNav.setItemBackgroundResource(R.color.app_green);
                        setFragment(statFragment);
                        break;
                    case R.id.id_bot_nav_notification:
                        bottomNav.setItemBackgroundResource(R.color.red_primary);
                        setFragment(notificationFragment);
                        break;
                }

                return true;
            }

        });;
        //fin de la partie navigation bottom
        //listener sur les voiture en panne

        return view_dashboard;


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.id_frame_du_dashboard,fragment);
        fragmentTransaction.commit();
    }


}
