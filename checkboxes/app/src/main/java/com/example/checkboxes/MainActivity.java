package com.example.checkboxes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox burger, pizza, coke, coffee;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = findViewById(R.id.c1);
        pizza = findViewById(R.id.c2);
        coffee = findViewById(R.id.c3);
        coke = findViewById(R.id.c4);
        button = findViewById(R.id.b1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected items: ");
                if (burger.isChecked()) {
                    result.append("Burger rs: 100");
                    total += 100;
                }
                if (pizza.isChecked()){
                    total+=200;
                    result.append(" Pizza rs : 200");
                }
                if (coffee.isChecked()){
                    total+=300;
                    result.append(" Coffee rs : 300");
                }
                if (coke.isChecked()){
                    total += 400;
                    result.append(" Coke rs : 400");
                }
                result.append(" Total: ₹ "+total);
                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();            }
        });
    }
}