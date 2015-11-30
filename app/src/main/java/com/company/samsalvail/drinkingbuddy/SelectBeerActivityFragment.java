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
public class SelectBeerActivityFragment extends Fragment {

    ImageView imgView6;
    public SelectBeerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_beer, container, false);

        imgView6 = (ImageView) v.findViewById(R.id.beerImg);
        imgView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffeeInt = new Intent(v.getContext(), BeerActivity.class);
                startActivity(coffeeInt);

            }
        });


        return v;
    }
}
