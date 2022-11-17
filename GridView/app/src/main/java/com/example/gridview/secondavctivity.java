package com.example.gridview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gridview.R;

class GridArrayAdapter extends ArrayAdapter {
    private int[] images = new int[]{};
    private String[] names = new String[]{};

    public GridArrayAdapter(@NonNull Context context, int resource, int[] images, String[] names) {
        super(context, resource);
        this.images = images;
        this.names = names;
    }
    @Override
    public int getCount() {
        return names.length;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.cell, null);

        TextView textView = (TextView) v.findViewById(R.id.txt);
        ImageView imageView = (ImageView) v.findViewById(R.id.img);

        textView.setText(names[position]);
        imageView.setImageResource(images[position]);

        return v;

    }

}
