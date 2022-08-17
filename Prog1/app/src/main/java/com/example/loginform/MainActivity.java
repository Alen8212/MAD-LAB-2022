package com.example.loginform;

//import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText e1,e2;
    Button bttn;
    String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.uname);
        e2=findViewById(R.id.psw);
        bttn=findViewById(R.id.login);
        bttn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String x="Admin";
        String y="123";
        a=e1.getText().toString();
        b=e2.getText().toString();
        if(a.equals(x) && b.equals(y)){
            Toast.makeText(this,"Login sucessful",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Invalid username or incorrect password", Toast.LENGTH_SHORT).show();
        }
    }
}