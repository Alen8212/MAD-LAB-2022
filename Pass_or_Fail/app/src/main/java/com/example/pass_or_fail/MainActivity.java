package com.example.pass_or_fail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calbutton).setOnClickListener(v -> {
            int m1 = Integer.parseInt(((EditText) findViewById(R.id.chem)).getText().toString());
            int m2 = Integer.parseInt(((EditText) findViewById(R.id.maths)).getText().toString());
            int m3 = Integer.parseInt(((EditText) findViewById(R.id.phy)).getText().toString());
            String name = ((EditText) findViewById(R.id.name)).getText().toString();
            Intent intent = new Intent(this,StatusActivity.class);
            intent.putExtra("marks", m1 + m2 + m3);
            intent.putExtra("name", name);
            startActivity(intent);
        });
    }
}