package ru.mirea.seyfetdinov.r.n.mireaproject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import ru.mirea.seyfetdinov.r.n.mireaproject.datafragments.BlackHole;
import ru.mirea.seyfetdinov.r.n.mireaproject.datafragments.Comets;
import ru.mirea.seyfetdinov.r.n.mireaproject.datafragments.Constellation;

public class DataFragment extends Fragment {

    Fragment fragmentBlackHole, fragmentConsellation,fragmentComet;
    Button blackHoleInfoBtn, consellationInfoBtn, cometInfoBtn;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        fragmentBlackHole = new BlackHole();
        fragmentConsellation = new Constellation();
        fragmentComet = new Comets();

        blackHoleInfoBtn = view.findViewById(R.id.BlackHoleInfoBtn);
        consellationInfoBtn = view.findViewById(R.id.consellationBtn);
        cometInfoBtn = view.findViewById(R.id.cometIntoBtn);

        blackHoleInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentBlackHole);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        consellationInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentConsellation);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cometInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentComet);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}