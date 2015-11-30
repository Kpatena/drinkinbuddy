package com.company.samsalvail.drinkingbuddy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectEnergyActivityFragment extends Fragment {
    ImageView imgView5;
    public SelectEnergyActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_energy, container, false);

        imgView5 = (ImageView) v.findViewById(R.id.energyImg);
        imgView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffeeInt = new Intent(v.getContext(), EnergyActivity.class);
                startActivity(coffeeInt);

            }
        });


        return v;
    }
}
