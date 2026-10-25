package com.example.partb3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    ProgressBar p;
    ConstraintLayout c;

    BroadcastReceiver reciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level",0);
            int scale = intent.getIntExtra("scale",100);
            int percent = level*100/scale;

            t1.setText("Battery: "+percent+"%");
            p.setProgress(percent);

            if (percent <= 20){
                c.setBackgroundColor(Color.RED);
            }else if (percent <= 60){
                c.setBackgroundColor(Color.BLUE);
            }else{
                c.setBackgroundColor(Color.GREEN);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        p = findViewById(R.id.batteryProgress);
        c = findViewById(R.id.main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(reciever, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(reciever);
    }
}