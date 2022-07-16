package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserFloods extends AppCompatActivity {




    TextView flood;
    String str =
            "\nWhat to do Before a Floods\n\n"+
                    "* Build an emergency kit and make a family communications plan.\n\n" +
                    "* Avoid building in a floodplain unless you elevate and reinforce your home.\n\n"+
                    "* Elevate the furnace, water heater and electric panel in your home if you live in an area that has a high flood risk.\n\n"+
                    "* Consider installing check valves to prevent flood water from backing up into the drains of your home.\n\n"+
                    "* If feasible, construct barriers to stop floodwater from entering the building and seal walls in basements with waterproofing compounds."+
                    "\n\n\n"+
                    "What to do During a Floods\n\n"+
                    "* Listen to the radio or television for information.\n\n"+
                    "* Be aware that flash flooding can occur. If there is any possibility of a flash flood, move immediately to higher ground. Do not wait for instructions to move.\n\n"+
                    "* Be aware of stream, drainage channels, canyons and other areas known to flood suddenly. Flash floods can occur in these areas with or without typical warnings such as rain clouds or heavy rain."+
                    "\n\n\n"+
                    "What to do After a Floods\n\n"+
                    "* Avoid moving water.\n\n" +
                    "* Stay away from damaged areas unless your assistance has been specifically requested by police, fire, or relief organization.\n\n"+
                    "* Emergency workers will be assisting people in flooded areas. You can help them by staying off the roads and out of the way.\n\n"+
                    "* Play it safe. Additional flooding or flash floods can occur. Listen for local warnings and information. If your car stalls in rapidly rising waters, get out immediately and climb to higher ground.\n\n"+
                    "* Return home only when authorities indicate it is safe.\n\n"+
                    "* Roads may still be closed because they have been damaged or are covered by water. Barricades have been placed for your protection. If you come upon a barricade or a flooded road, go another way.\n\n"+
                    "* If you must walk or drive in areas that have been flooded.\n\n"+
                    "* Stay on firm ground. Moving water only 6 inches deep can sweep you off your feet. Standing water may be electrically charged from underground or downed power lines.\n\n"+
                    "* Flooding may have caused familiar places to change. Floodwaters often erode roads and walkways. Flood debris may hide animals and broken bottles, and it's also slippery. Avoid walking or driving through it.\n\n"+
                    "* Be aware of areas where floodwaters have receded. Roads may have weakened and could collapse under the weight of a car.\n\n"+
                    "* Stay out of any building if it is surrounded by floodwaters.\n\n"+
                    "* Use extreme caution when entering buildings; there may be hidden damage, particularly in foundations.\n"+
                    "\n\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_user_floods);


        flood = findViewById(R.id.text4);

        loadText();
    }

    private void loadText(){

        flood.setMovementMethod(new ScrollingMovementMethod());
        flood.setText(str);

    }

}
