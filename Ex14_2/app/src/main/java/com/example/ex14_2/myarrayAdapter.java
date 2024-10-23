package com.example.ex14_2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class myarrayAdapter extends ArrayAdapter<Item> {
    Activity context;
    ArrayList<Item> myArray;
    int LayoutId;

    public myarrayAdapter(Activity context, int LayoutId, ArrayList<Item> myArray) {
        super(context, LayoutId, myArray);
        this.context = context;
        this.myArray = myArray;
        this.LayoutId = LayoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);

        Item myItem = myArray.get(position);

        TextView txtmaso = convertView.findViewById(R.id.txtmaso);
        txtmaso.setText(myItem.getMaso());

        TextView txttieude = convertView.findViewById(R.id.txttieude);
        txttieude.setText(myItem.getTieude());

        ImageButton btnlike = convertView.findViewById(R.id.btnlike);
        if (myItem.getThich() == 1) {
            btnlike.setImageResource(R.drawable.like);
        } else {
            btnlike.setImageResource(R.drawable.unlike);
        }

        return convertView;
    }
}

