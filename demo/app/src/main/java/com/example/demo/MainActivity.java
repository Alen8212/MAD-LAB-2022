package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyHelper myhelper;
    EditText eName, eLoc;
    Button bAdd, bView;
    LinearLayout l1, l4;
    ImageView img;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myhelper = new MyHelper(this);
        SQLiteDatabase sql = myhelper.getWritableDatabase();
        eName = (EditText) findViewById(R.id.name);
        eLoc = (EditText) findViewById(R.id.loc);
        bAdd = (Button) findViewById(R.id.add);
        bAdd.setOnClickListener(this);
        bView = (Button) findViewById(R.id.view);
        bView.setOnClickListener(this);
        l1 = (LinearLayout) findViewById(R.id.lay1);
        img = (ImageView) findViewById(R.id.img1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    public void visi() {
        img.setVisibility(View.GONE);
        l1.setVisibility(View.GONE);
        t1.setText(" ");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        visi();
        switch (item.getItemId()) {
            case R.id.a1:
                l1.setVisibility(View.VISIBLE);
                break;

            case R.id.a4:
                l4.setVisibility(View.VISIBLE);
                break;

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            String user = eName.getText().toString();
            String loc = eLoc.getText().toString();
            long id = myhelper.insertData(user, loc);
            if (id < 0)
                Toast.makeText(this, "Unsuccessful Insertion", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.view) {
            String a = myhelper.getAllData();
            t1.setText(a);
        }
    }
}
class MyHelper extends SQLiteOpenHelper {
    MyHelper(Context c) {
        super(c, "deptDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE dept (deptid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(30), location VARCHAR(10));");
        } catch (SQLException e) {
            System.out.println("hi");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertData(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", username);
        cv.put("location", password);
        long rowid = db.insert("dept", null, cv);
        return rowid;
    }

    public String getAllData() {
        // SELECT id, name, loc FROM dept
        SQLiteDatabase db = getWritableDatabase();
        String columns[] = {"deptid", "name", "location"};
        Cursor cr = db.query("dept", columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cr.moveToNext()) {
            int pid = cr.getInt(0);
            String name = cr.getString(1);
            String password = cr.getString(2);
            buffer.append(pid + " --- " + name + " --- " + password + "\n");
        }
        return buffer.toString();
    }

}