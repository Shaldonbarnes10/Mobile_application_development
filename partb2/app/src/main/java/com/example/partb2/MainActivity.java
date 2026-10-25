package com.example.partb2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t1;
    ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);
        p = findViewById(R.id.progressBar);
        p.setMax(1000);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountTask().execute();
            }
        });

    }

    class CountTask extends AsyncTask<Void, Integer, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=1;i<=1000;i++){
                publishProgress(i);
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            p.setProgress(values[0]);
            t1.setText(""+values[0]);
            super.onProgressUpdate(values);
        }
    }
}