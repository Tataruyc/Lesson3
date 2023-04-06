package ru.mirea.seyfetdinov.r.n.intentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button enterTheDate;
    private EditText editText;
    String actDate;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.actualDate);
        enterTheDate = findViewById(R.id.enterTheDate);
        editText = findViewById(R.id.numberOfGroup);

        long dateInMiles = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(new Date(dateInMiles));

        //actDate = savedInstanceState.getString("dataKey", dateString);

        View.OnClickListener oclEnterTheDate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(dateString);
            }
        };
        enterTheDate.setOnClickListener(oclEnterTheDate);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString("data_value");
        if (text != null) editText.setText(text);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("data_value", editText.getText().toString());
    }


    public void invokeSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", editText.getText().toString());
        intent.putExtra("date", textView.getText().toString());
        startActivity(intent);
    }
}