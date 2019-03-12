package com.fulthonn.navigation_menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class fragment_dashboard extends Fragment  {
    LinearLayout total_vehicule;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = getContext().getApplicationContext();
        final View view = inflater.inflate(R.layout.fragment_dashboard,container,false);
        total_vehicule = view.findViewById(R.id.id_total_voiture);
        total_vehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(),SampleActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }



}
