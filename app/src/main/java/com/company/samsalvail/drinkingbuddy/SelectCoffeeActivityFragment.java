package com.company.samsalvail.drinkingbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectCoffeeActivityFragment extends Fragment implements AdapterView.OnItemClickListener{

    ImageView imgView;
    public SelectCoffeeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_select_coffee, container, false);

        imgView = (ImageView) v.findViewById(R.id.coffeeImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffeeInt = new Intent(v.getContext(), CoffeeActivity.class);
                startActivity(coffeeInt);

            }
        });


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}
