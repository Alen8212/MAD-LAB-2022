package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculate(View view) {
        float num1,num2;
        float result = 0;



        EditText res = (EditText) findViewById(R.id.result);
        EditText e1 = (EditText) findViewById(R.id.num1);
        EditText e2 = (EditText) findViewById(R.id.num2);

        if (e1.getText().toString().equals("") || e2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
            return;
        }

        num1 = Integer.parseInt(e1.getText().toString());
        num2 = Integer.parseInt(e2.getText().toString());

        switch (view.getId()) {

            // cases applied over different buttons
            case R.id.addBtn:
                result = num1+num2;
                break;

            case R.id.subBtn:
                result = num1-num2;
                break;

            case R.id.mulBtn:
                result = num1*num2;
                break;

            case R.id.divBtn:
                result = num1/num2;
                break;

            default:
                Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();


        }

        res.setText(result + "");

    }
}