package ru.mirea.seyfetdinov.r.n.mireaproject;

import static ru.mirea.seyfetdinov.r.n.mireaproject.databinding.ActivityMainBinding.inflate;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class WorkingWithFileFragment extends Fragment {

    private Button createFileBtn, downloadFileBtn;
    private TextView showText;
    public SharedPreferences sharedPref;
    public byte[] shiper;
    public SecretKey key;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_working_with_file, container, false);

        createFileBtn = view.findViewById(R.id.createFileBtn);
        downloadFileBtn = view.findViewById(R.id.downloadFile);
        showText = view.findViewById(R.id.showText);
        sharedPref = getActivity().getSharedPreferences("person_Profile", Context.MODE_PRIVATE);

        createFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Создание файла");

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_encrypt, null, false);
                builder.setView(view);

                EditText text = view.findViewById(R.id.edit_text);

                builder.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        key = generateKey();
                        shiper = encryptMsg(text.getText().toString(), key);

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("message" , shiper.toString());
                        editor.apply();
                    }
                });

                builder.setNegativeButton("Отмена", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }


        });

        downloadFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedText = sharedPref.getString("message", "фаифаифавифваи");
                showText.setText(savedText);

            }
        });
        return view;
    }

    public static SecretKey generateKey(){
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed("any data used as random seed".getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256, sr);
            return new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static byte[] encryptMsg(String message, SecretKey secret) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            return cipher.doFinal(message.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }

}