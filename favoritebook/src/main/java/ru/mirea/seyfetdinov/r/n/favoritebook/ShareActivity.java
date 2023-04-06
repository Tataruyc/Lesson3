package ru.mirea.seyfetdinov.r.n.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView;
    String finalText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        editText = findViewById(R.id.enterFavoriteBookText);
        button = findViewById(R.id.sendText);
        textView = findViewById(R.id.favoriteBoolText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String university = extras.getString(MainActivity.KEY);
            finalText = textView.getText().toString() + university;
        }

        textView.setText(finalText);

        String text = editText.getText().toString();

        View.OnClickListener oclEnterTheData = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(MainActivity.USER_MESSAGE, editText.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        };
        button.setOnClickListener(oclEnterTheData);

    }


}
