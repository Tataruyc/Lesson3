package ru.mirea.seyfetdinov.r.n.mireaproject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.seyfetdinov.r.n.mireaproject.hardwarefragments.Accelerometer;
import ru.mirea.seyfetdinov.r.n.mireaproject.hardwarefragments.AudioRecorder;
import ru.mirea.seyfetdinov.r.n.mireaproject.hardwarefragments.Camera;


public class HardwareFragment extends Fragment {

    private Fragment accelerometerFragment, cameraFragment, recordFragment;

    private Button accelerometerBtn;
    private Button cameraBtn;
    private Button recorderBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hardware, container, false);

        accelerometerBtn = view.findViewById(R.id.accelerometerBtn);
        cameraBtn = view.findViewById(R.id.cameraBtn);
        recorderBtn = view.findViewById(R.id.recorderBtn);

        accelerometerFragment = new Accelerometer();
        cameraFragment = new Camera();
        recordFragment = new AudioRecorder();

        accelerometerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentCont, accelerometerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentCont, cameraFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        recorderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentCont, recordFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}