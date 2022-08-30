package com.example.ui_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL;
    Button B;
    TextView T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LL = new LinearLayout(this);
        B = new Button(this);
        T = new TextView(this);

        LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams vdim = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vdim.setMargins(0, 60, 0,0);

        LL.setLayoutParams(dim);
        B.setLayoutParams(vdim);
        T.setLayoutParams(vdim);

        LL.setOrientation(LinearLayout.VERTICAL);
        LL.setGravity(Gravity.CENTER);

        B.setText("BUTTON");

        B.setBackgroundColor(Color.BLUE);

        T.setText("TEXT");
        T.setTextSize(34);
        T.setTextColor(Color.WHITE);
        T.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        LL.addView(T);
        LL.addView(B);
        setContentView(LL);
    }
}
