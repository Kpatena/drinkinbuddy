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
public class SelectTeaActivityFragment extends Fragment {

    ImageView imgView2;

    public SelectTeaActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_select_tea, container, false);

        imgView2 = (ImageView) v.findViewById(R.id.teaImg);
        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffeeInt = new Intent(v.getContext(), TeaActivity.class);
                startActivity(coffeeInt);

            }
        });


        return v;
    }
}
