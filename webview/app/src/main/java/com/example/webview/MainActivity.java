package com.example.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b11,b21;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b11 = findViewById(R.id.b1);
        b21 = findViewById(R.id.b2);
        e = findViewById(R.id.e1);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("load", "defaultPage");
                startActivity(i);
            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e.getText().toString();
                if (!s.isEmpty()){
                    if (!s.startsWith("http://") && !s.startsWith("https://")){
                        s = "https://"+s;
                    }
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("load",s);
                    startActivity(i);
                }
            }
        });
    }
}