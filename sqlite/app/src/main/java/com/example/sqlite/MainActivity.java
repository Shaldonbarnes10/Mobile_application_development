
package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    Button ins, sel;
    TextView t;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);

        ins = findViewById(R.id.b1);
        sel = findViewById(R.id.b2);
        t = findViewById(R.id.t1);

        // INSERT button
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openOrCreateDatabase("sample", MODE_PRIVATE, null);

                db.execSQL("CREATE TABLE IF NOT EXISTS TEST(name VARCHAR, age VARCHAR, address VARCHAR)");

//                db.execSQL("INSERT INTO TEST VALUES(?,?,?)",
//                        new String[]{
//                                e1.getText().toString(),
//                                e2.getText().toString(),
//                                e3.getText().toString()
//                        });

                db.execSQL("INSERT INTO TEST VALUES ('"+e1.getText().toString()+"','"+e2.getText().toString()+"','"+e3.getText().toString()+"')");

                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                db.execSQL("DELETE FROM TEST");
                db.close();
            }
        });

        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openOrCreateDatabase("sample", MODE_PRIVATE, null);

                db.execSQL("CREATE TABLE IF NOT EXISTS TEST(name VARCHAR, age VARCHAR, address VARCHAR)");

                Cursor c = db.rawQuery("SELECT * FROM TEST", null);

                StringBuilder s = new StringBuilder("Name\tAge\tAddress\n");

                while (c.moveToNext()) {
                    s.append(c.getString(0)).append("\t")
                            .append(c.getString(1)).append("\t")
                            .append(c.getString(2)).append("\n");
                }

                t.setText(s.toString());

                c.close();
                db.close();
            }
        });
    }
}