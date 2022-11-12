package com.example.burgercaloriecounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//Import required libraries
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    //View references
    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    //Private data member | Model
    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Initialize model
        burger = new Burger();
        initialize();

        registerChangeListener();
    }

    //Get view references and display calories in view
    private void initialize()
    {
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        prosciuttoCBX = (CheckBox) findViewById(R.id.checkBox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar) findViewById(R.id.seekBar1);
        caloriesTV = (TextView) findViewById(R.id.textView2);

        //Display values in view
        displayCalories();
    }

    //Add action listeners to view objects
    private void registerChangeListener()
    {
        pattyRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {
        @Override
        //Set the calories to the correct value based on the radio button pressed
        public void onCheckedChanged(RadioGroup radioGroup, int radioId) {
            switch (radioId)
            {
                //Set to beef
                case R.id.radio0:
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                //Set to lamb
                case R.id.radio1:
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                //Set to ostrich
                case R.id.radio2:
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                //Set cheese to asiago
                case R.id.radio3:
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                //Set cheese to creme fraiche
                case R.id.radio4:
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
                    break;
            }
            //Update view
            displayCalories();
        }
    };

    //Check box listener
    private OnClickListener baconListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            //If checked, set the value, else reset to 0
            if (((CheckBox) view).isChecked())
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            else
                burger.clearProsciuttoCalories();

            //Update view
            displayCalories();
        }
    };

    //Seek bar listener
    private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            //Set calories equal to the value from the seek bar
            burger.setSauceCalories(seekBar.getProgress());
            //Update view
            displayCalories();
        }

        //Empty implementations, not needed
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    };

    //Update the view textView to display the current number of calories
    private void displayCalories()
    {
        //Set text to total calories
        String calorieText = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }
}