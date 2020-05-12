package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



public class ColorActivity extends AppCompatActivity {


    //Listing colors as Strings
    String[] Colors = new String[]{
            "Red" ,
            "Orange",
            "Yellow",
            "Green",
            "Lime" ,
            "Blue",
            "Purple",
            "Cyan",
            "Navy",
            "Grey",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner ColorSpinner = findViewById(R.id.coloredSpinner);
        final View selectedColor;
        selectedColor = this.getWindow().getDecorView();

        //Creating an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> ColorNames = ArrayAdapter.createFromResource(this,R.array.colorPalatte, android.R.layout.simple_spinner_item);

        //Specifying the layout for the choices
        ColorNames.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply the adapter to the spinner
        ColorSpinner.setAdapter( new ColorAdapter(this));



        ColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            //Making an array of integers, the array refers to the colorPalatte array
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Sets background color of selected name to white
                view.setBackgroundResource(R.color.White);

                //Once color name is clicked on, background color will change to color selected
                ArrayList<Integer> ColorNames;
                ColorNames = new ArrayList<Integer>();
                int [] getColors = getResources().getIntArray(R.array.colorPalatte);
                for(int i:getColors){
                    ColorNames.add(i);
                }
                Object item = parent.getItemAtPosition(position);
                if(item!=null){
                    selectedColor.setBackgroundColor(ColorNames.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

    }
}
