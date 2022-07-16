package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserEarthquake extends AppCompatActivity {



    TextView earthquake;
    String str =
            "\nWhat to Do Before an Earthquake\n\n"+
                    "* Make sure you have a fire extinguisher, first aid kit, a battery-powered radio, a flashlight, and extra batteries at home.\n\n"+
                    "* Learn first aid.\n\n"+
                    "* Learn how to turn off the gas, water, and electricity.\n\n\n"+
                    "* Make up a plan of where to meet your family after an earthquake.\n\n"+
                    "* Don't leave heavy objects on shelves (they'll fall during a quake).\n\n"+
                    "* Anchor heavy furniture, cupboards, and appliances to the walls or floor.\n\n" +
                    "* Learn the earthquake plan at your school or workplace." +
                    "\n\n\n"+
                    "What to Do During an Earthquake\n\n"+
                    "* Stay calm! If you're indoors, stay inside. If you're outside, stay outside.\n\n"+
                    "* If you're indoors, stand against a wall near the center of the building, stand in a doorway, or crawl under heavy furniture (a desk or table). Stay away from windows and outside doors.\n\n"+
                    "* If you're outdoors, stay in the open away from power lines or anything that might fall. Stay away from buildings (stuff might fall off the building or the building could fall on you).\n\n"+
                    "* Don't use matches, candles, or any flame. Broken gas lines and fire don't mix.\n\n"+
                    "* If you're in a car, stop the car and stay inside the car until the earthquake stops.\n\n"+
                    "* Don't use elevators (they may shut down)."+
                    "\n\n\n"+
                    "What to Do After an Earthquake\n\n"+
                    "* Check yourself and others for injuries. Provide first aid for anyone who needs it.\n\n" +
                    "* Check water, gas, and electric lines for damage. If any are damaged, shut off the valves. Check for the smell of gas. If you smell it, open all the windows and doors, leave immediately, and report it to the authorities (use someone else's phone).\n\n\n"+
                    "* Turn on the radio. Don't use the phone unless it's an emergency.\n\n"+
                    "* Stay out of damaged buildings.\n\n"+
                    "* Be careful around broken glass and debris. Wear boots or sturdy shoes to keep from cutting your feet.\n\n"+
                    "* Be careful of chimneys (they may fall on you).\n\n"+
                    "* Stay away from beaches. Tsunamis and seiches sometimes hit after the ground has stopped shaking.\n\n"+
                    "* Stay away from damaged areas.\n\n"+
                    "* If you're at school or work, follow the emergency plan or the instructions of the person in charge.\n" +
                    "Expect aftershocks"+
                    "\n\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_user_earthquake);

        earthquake= findViewById(R.id.text1);

        loadText();
    }

    private void loadText(){

        earthquake.setMovementMethod(new ScrollingMovementMethod());
        earthquake.setText(str);

    }



}
