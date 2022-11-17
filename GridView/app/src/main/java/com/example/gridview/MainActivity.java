package com.example.gridview;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int image[]={R.drawable.fi1, R.drawable.fi2, R.drawable.fi3,R.drawable.fi4,R.drawable.fi5,R.drawable.fi6,R.drawable.fi7,R.drawable.fi8};
    String[] names = {"India","United Kingdom", "U.S.A.", "China", "Germany", "Sri Lanka", "Australia", "Argentina"};
    GridView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (GridView) findViewById(R.id.grid);
        GridArrayAdapter gridArrayAdapter = new GridArrayAdapter(this, R.layout.cell, image,names);
        g.setAdapter(gridArrayAdapter);
        g.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you know the flag of "+names[position]+"?");
        builder.setPositiveButton("YES",null);
        builder.setNegativeButton("NO",null);
        AlertDialog a = builder.create();
        a.show();
    }
}
