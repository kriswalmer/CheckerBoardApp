package edu.temple.tue80717.checkerboardapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kris on 9/29/15.
 */
public class RowAdapter extends ArrayAdapter<Item> {

    Context context;
    int layoutResourceId;

    ArrayList<Item> data = new ArrayList<Item>();

    public RowAdapter(Context context, int layoutResourceId,
                      ArrayList<Item> data ,Resources res) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TextView textView = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            textView = (TextView) row.findViewById(R.id.CheckerTextView);
            row.setTag(textView);
        } else {
            textView = (TextView)row.getTag();
        }

        Item item = data.get(position);
        Resources res = context.getResources();
        String numberArray[] = context.getResources().getStringArray(R.array.number_array);
        String textForTV = Integer.toString(item.getColumns());

        for( int l = 0 ; l < 145; l++ )
        {
            if (textForTV.equals(Integer.toString(l)))
            {
                textForTV = numberArray[l-1];
            }

        }

/*
        if (textForTV.equals("1")) {
            textForTV = numberArray[0];
        }if (textForTV.equals("2")){
            textForTV = "two";

*/


        textView.setText(textForTV);

        if(item.getBlackSquare()){
            textView.setBackgroundColor(Color.parseColor("black"));
            textView.setTextColor(Color.parseColor("white"));
        } else {
            textView.setBackgroundColor(Color.parseColor("white"));
            textView.setTextColor(Color.parseColor("black"));
        }
        return row;

    }







}
