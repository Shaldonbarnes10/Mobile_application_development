package com.example.randomcolor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.Button;
import android.view.View;
import java.util.Random;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout layout = findViewById(R.id.main);
                Random gen = new Random();
                int red = gen.nextInt(256);
                int green = gen.nextInt(256);
                int blue = gen.nextInt(256);
                layout.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
    }
}