package com.example.ex13_3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int layoutId;
    ArrayList<Phone> phoneList;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<Phone> phoneList) {
        super(context, layoutId, phoneList);
        this.context = context;
        this.layoutId = layoutId;
        this.phoneList = phoneList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(layoutId, null);

        Phone phone = phoneList.get(position);

        ImageView imageView = rowView.findViewById(R.id.imgphone);
        TextView textView = rowView.findViewById(R.id.txtnamephone);

        imageView.setImageResource(phone.getImagePhone());
        textView.setText(phone.getNamePhone());

        return rowView;
    }
}

