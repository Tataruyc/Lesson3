package ru.mirea.seyfetdinov.r.n.intentapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        textView = findViewById(R.id.nowDate);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value = extras.getString("key");
            String date = extras.getString("date");
            int number;
            try {
                number = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                number = 0;
                Toast.makeText(getApplicationContext(), "Вы ввели неверное значение номера", Toast.LENGTH_SHORT).show();
            }
            number = number * number;

            String finalData = "Квадрат значения моего номера по списку в группе состваляет: " + String.valueOf(number) + " ,а текущее время: " + date;
            textView.setText(finalData);
        }

    }
}
