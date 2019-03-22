package com.fulthonn.navigation_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fulthonn.model.LocalBd;
import com.fulthonn.model.Voiture;
import com.fulthonn.navigation_menu.Voitures.VoitureAccidentActivity;
import com.fulthonn.navigation_menu.Voitures.VoitureActivity;
import com.fulthonn.navigation_menu.Voitures.VoitureEnPanneActivity;

public class HomeFragment extends Fragment {
    LinearLayout voitureDisponible;
    LinearLayout voitureTotal;
    LinearLayout voitureEnPanne;
    LinearLayout voitureAccident;
    TextView nombreVoitureDisponible;
    TextView nombreTotalVoiture;



    FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_home, container, false);


        voitureDisponible=v.findViewById(R.id.id_voiture_diponible);
        voitureEnPanne= v.findViewById(R.id.voiture_EnPanne);
        voitureAccident=v.findViewById(R.id.voiture_Accident);
        nombreVoitureDisponible=v.findViewById(R.id.id_nombreVoiture_disponible);
        nombreTotalVoiture=v.findViewById(R.id.id_nombre_total_voiture);
        voitureTotal =v.findViewById(R.id.id_total_voiture);

        voitureTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategorie = new Intent(getContext().getApplicationContext(),CategoryActivity.class);
                startActivity(intentCategorie);
            }
        });

        nombreVoitureDisponible.setText(String.valueOf(LocalBd.getNombreTotalVoiture()));

        voitureDisponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTotalVoiture = new Intent(getContext().getApplicationContext(), VoitureActivity.class);
                startActivity(intentTotalVoiture);
            }
        });

        voitureEnPanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoitureENPanne = new Intent(getContext().getApplicationContext(), VoitureEnPanneActivity.class);
                startActivity(intentVoitureENPanne);
            }
        });
        voitureAccident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoitureAccident = new Intent(getContext().getApplicationContext(), VoitureAccidentActivity.class);
                startActivity(intentVoitureAccident);
            }
        });


        return  v;
    }

}
