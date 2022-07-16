package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserHuricane extends AppCompatActivity {


    TextView hurricane;
    String str =
            "\nWhat to do Before a Hurricane\n\n"+
                    "* Locate a safe room or the safest areas of your home or for each hurricane hazard. The safest areas may not actually be your home, but within your community.\n\n" +
                    "* Stock non-perishable food supplies, bottled water, a first-aid kit, a battery-powered radio, flashlights and extra batteries in air-tight containers. Use our hurricane grocery list to ensure you have everything you need.\n\n"+
                    "* Adjust refrigerator temperatures to the coldest settings to reduce the potential for food spoiling if the power is temporarily lost.\n\n"+
                    "* Have a non-electric analog telephone or a fully-charged cell phone available in case you need to make an emergency call during a power outage.\n\n"+
                    "* Fill bathtubs and sinks with water to ensure you have enough to flush the toilet, cook, etc. in case of a power outage."+
                    "\n\n\n"+
                    "What to do During a Hurricane\n\n"+
                    "* Monitor the radio or television for weather conditions and updates.\n\n"+
                    "* Stay away from all windows and exterior doors and seek shelter in a bathroom or basement. Bathtubs can provide some shelter if you cover yourself with plywood or other materials.\n\n"+
                    "* Evacuate to a shelter or a neighbor's home if your home is damaged or if you are instructed to do so by emergency personnel.\n\n"+
                    "* If power is lost, turn off all major appliances to reduce the chances of damage in the event of a power surge.\n\n"+
                    "* If flooding nears your home, turn off the electricity at the main breaker."+
                    "\n\n\n"+
                    "What to do After a Hurricane\n\n"+
                    "* When power returns to your home, do not start all major appliances at once. Turn them on gradually to reduce damage to sensitive equipment.\n\n" +
                    "* Avoid downed, damaged or loose power lines and report them immediately to the local police and fire department, as well as to the local transmission and distribution services utility in your area.\n\n"+
                    "* Even if you have ventilation, never use a generator indoors. This includes garages, basements and crawlspaces. Exhaust fumes contain high levels of carbon monoxide, which can be deadly if inhaled. Even when left outside, keep generators away from doors and windows and at least 10 feet away from your home. Also, allow your generator to cool off before refilling it with gas – splashing gas on hot generator components can lead to a fire.\n\n"+
                    "* Do not use electrical or gas appliances that have been wet, and do not turn on damaged appliances because of the hazards of electric shock or fire.\n\n"+
                    "* Never use charcoal indoors because burning charcoal produces high levels of carbon monoxide that can reach lethal levels in enclosed spaces.\n\n"+
                    "* Follow post-storm food and water safety precautions to protect your family from contamination.\n\n"+
                    "* Stay away from flood waters as they can contain harmful contaminates and hide dangerous debris.\n\n"+
                    "* Take photographs of any damage incurred.\n\n"+
                    "* If flooding or water damaged occurred, begin cleaning up and repairs as soon as possible to avoid mold and be sure to wear protective gear"+
                    "\n\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_user_huricane);


        hurricane = findViewById(R.id.text2);

        loadText();
    }

    private void loadText() {

        hurricane.setMovementMethod(new ScrollingMovementMethod());
        hurricane.setText(str);

    }
}
