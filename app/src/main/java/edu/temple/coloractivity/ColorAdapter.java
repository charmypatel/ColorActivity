package edu.temple.coloractivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ColorAdapter extends BaseAdapter {

    ArrayList<Integer> ColorNames;

    Context color;


    public ColorAdapter(Context color){
        this.color=color;
        ColorNames = new ArrayList<Integer>();
        int [] getColors = color.getResources().getIntArray(R.array.colorPalatte);

        for(int i:getColors){
            ColorNames.add(i);
        }

    }

    @Override
    public int getCount() {

        return ColorNames.size();
    }

    @Override
    public Object getItem(int i) {

        return ColorNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    //Setting getColorName to array of strings with color names
    public String getColor(int i ){
        String getColorName [] = color.getResources().getStringArray(R.array.Colors);
        return getColorName[i];

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layout = LayoutInflater.from(color);
        view = layout.inflate(android.R.layout.simple_spinner_dropdown_item,null);
        TextView text = view.findViewById(android.R.id.text1);
        text.setBackgroundColor(ColorNames.get(i));
        text.setText(getColor(i));
        return view;

    }
}

