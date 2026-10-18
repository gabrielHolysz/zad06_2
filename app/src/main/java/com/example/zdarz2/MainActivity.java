package com.example.zdarz2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        textView.setText(String.valueOf(licznik));
        View.OnClickListener symbolListener = v -> {
            Button button = (Button) v;
            String buttonText = button.getText().toString();

            // Sprawdzamy treść napisu na przycisku
            if (buttonText.equals("+1")) {
                licznik++;
                textView.setText(String.valueOf(licznik));
            } else if (buttonText.equals("-1")) {
                if (licznik > 0) {
                    licznik--;
                    textView.setText(String.valueOf(licznik));
                } else {
                    // Wymóg z zadania: obsługa sytuacji błędnej (Toast zamiast zejścia poniżej zera)[cite: 4]
                    Toast.makeText(this, "Licznik nie może spaść poniżej 0!", Toast.LENGTH_SHORT).show();
                }
            }

        };
        int[] symbolIds = {
                R.id.button, R.id.button2
        };
        for (int id : symbolIds) {
            findViewById(id).setOnClickListener(symbolListener);
        }
    }



    public void onClickreset(View view) {
        licznik= 0;
        textView.setText(String.valueOf(licznik));
    }
}