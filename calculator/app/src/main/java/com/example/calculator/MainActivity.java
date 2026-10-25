package com.example.calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2;
    Button add,sub,div,mul,cl;
    TextView result;
    int a,b,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        result = findViewById(R.id.ans);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        cl = findViewById(R.id.clear);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(n1.getText().toString());
                b = Integer.parseInt(n2.getText().toString());
                res = a+b;
                result.setText(Integer.toString(res));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(n1.getText().toString());
                b = Integer.parseInt(n2.getText().toString());
                res = a-b;
                result.setText(Integer.toString(res));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(n1.getText().toString());
                b = Integer.parseInt(n2.getText().toString());
                res = a*b;
                result.setText(Integer.toString(res));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(n1.getText().toString());
                b = Integer.parseInt(n2.getText().toString());
                res = a/b;
                result.setText(Integer.toString(res));
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1.setText("");
                n2.setText("");
                result.setText("Result: 0");
            }
        });
    }
}