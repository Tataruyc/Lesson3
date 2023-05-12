package ru.mirea.seyfetdinov.r.n.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Profile_Fragment extends Fragment {

    private EditText fioText;
    private EditText placeOfStudyText;
    private EditText hobbyText;
    private EditText favoriteSubjectText;
    private Button saveBtn;
    public SharedPreferences sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        fioText = view.findViewById(R.id.fioText);
        placeOfStudyText = view.findViewById(R.id.placeOfStudyText);
        hobbyText = view.findViewById(R.id.hobbyText);
        favoriteSubjectText = view.findViewById(R.id.favoriteSubjectText);
        saveBtn = view.findViewById(R.id.saveBtn);

        sharedPref = getActivity().getSharedPreferences("person_Profile", Context.MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString("person_FIO", fioText.getText().toString());
                editor.putString("person_PlaceOfStudy", placeOfStudyText.getText().toString());
                editor.putString("person_Hobby", hobbyText.getText().toString());
                editor.putString("person_FavoriteSubject", favoriteSubjectText.getText().toString());

                editor.apply();
            }
        });

        String personFIO = sharedPref.getString("person_FIO", "Anonymous");
        String peronsPlaceOfStudy = sharedPref.getString("person_PlaceOfSrudy", "Без места обучения");
        String personHobby = sharedPref.getString("person_Hobby", "Валяться на диване");
        String personFavoriteSubject = sharedPref.getString("person_FavoriteSubject", "null");

        fioText.setText(personFIO);
        placeOfStudyText.setText(peronsPlaceOfStudy);
        hobbyText.setText(personHobby);
        favoriteSubjectText.setText(personFavoriteSubject);

        return view;
    }

}