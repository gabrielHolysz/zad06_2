package com.example.zdarz2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int licznik = 0;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        View.OnClickListener symbolListener =
                v -> appendSymbol(((Button) v).getText().toString());
        int[] symbolIds = {
                R.id.button, R.id.button2
        };
        for (int id : symbolIds) {
            findViewById(id).setOnClickListener(symbolListener);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void appendSymbol(String symbol) {
        if (textView.getText().toString().equals("+1")) {
            licznik++;
            textView.setText(licznik);
        } else {
            licznik--;
            textView.setText(licznik);
    }
    }

    public void onClickreset(View view) {
        licznik= 0;
        textView.setText(licznik);
    }
}