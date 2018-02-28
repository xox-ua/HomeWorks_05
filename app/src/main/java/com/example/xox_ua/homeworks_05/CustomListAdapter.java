package com.example.xox_ua.homeworks_05;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] countryN;
    private final int[] countryF;

    public CustomListAdapter(Activity context, String[] countryN, int[] countryF) {
        super(context, R.layout.item_list, countryN);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.countryN=countryN;
        this.countryF=countryF;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list, null,true);

        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

        textView.setText(countryN[position]);
        imageView.setImageResource(countryF[position]);

        return rowView;
    };

    public void add(String s, int zz_flg_eu) {
    }
}