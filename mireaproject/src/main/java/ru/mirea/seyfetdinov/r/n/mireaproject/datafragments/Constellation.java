package ru.mirea.seyfetdinov.r.n.mireaproject.datafragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.seyfetdinov.r.n.mireaproject.R;

public class Constellation extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_constellation, container, false);
    }
}