package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserTsunami extends AppCompatActivity {

    TextView tsunami;
    String str =
            "\nWhat to do Before a Tsunami\n\n"+
                    "* Learn the signs of a potential tsunami, such as an earthquake, a loud roar from the ocean, or unusual ocean behavior, such as a sudden rise or wall of water or sudden draining of water showing the ocean floor.\n\n" +
                    "* Know and practice community evacuation plans. Some at-risk communities have maps with evacuation zones and routes. Map out your routes from home, work and play. Pick shelters 100 feet or more above sea level, or at least one mile inland.\n\n"+
                    "* Create a family emergency communication plan that has an out-of-state contact. Plan where to meet if you get separated.\n\n"+
                    "* Sign up for your community’s warning system. The Emergency Alert System (EAS) and National Oceanic and Atmospheric Administration (NOAA) Weather Radio also provide emergency alerts."+
                    "\n\n\n"+
                    "What to do During a Tsunami\n\n"+
                    "* If there is an earthquake and you are in a tsunami area, protect yourself from the earthquake first. Drop, Cover, and Hold On. Drop to your hands and knees. Cover your head and neck with your arms. Hold on to any sturdy furniture until the shaking stops. Crawl only if you can reach a better cover, but do not go through an area with more debris\n\n"+
                    "* When the shaking stops, if there are natural signs or official warnings of a tsunami, move immediately to a safe place as high and as far inland as possible. Listen to the authorities, but do not wait for tsunami warnings and evacuation orders.\n\n"+
                    "* If you are outside of the tsunami hazard zone and receive a warning, stay where you are unless officials tell you otherwise.\n\n"+
                    "* Leave immediately if you are told to do so. Evacuation routes often are marked by a wave with an arrow in the direction of higher ground.\n\n"+
                    "* If you are in the water, then grab onto something that floats, such as a raft or tree trunk.\n\n"+
                    "* If you are in a boat, face the direction of the waves and head out to sea. If you are in a harbor, go inland.\n\n"+
                    "\n\n\n"+
                    "What to do After a Tsunami\n\n"+
                    "* Listen to local alerts and authorities for information on areas to avoid and shelter locations.\n\n\n" +
                    "* Save phone calls for emergencies. Phone systems often are down or busy after a disaster. Use text messages or social media to communicate with family and friends.\n\n"+
                    "* Avoid wading in floodwater, which can contain dangerous debris. Water may be deeper than it appears.\n\n"+
                    "* Be aware of the risk of electrocution. Underground or downed power lines can electrically charge water. Do not touch electrical equipment if it is wet or if you are standing in water.\n\n"+
                    "* Stay away from damaged buildings, roads and bridges.\n\n"+
                    "* If you become injured or sick and need medical attention, contact your healthcare provider and shelter in place, if possible. Call 9-1-1 if you are experiencing a medical emergency.\n\n"+
                    "* Document property damage with photographs. Conduct an inventory and contact your insurance company for assistance."+
                    "\n\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_user_tsunami);


        tsunami = findViewById(R.id.text5);

        loadText();
    }

    private void loadText(){

        tsunami.setMovementMethod(new ScrollingMovementMethod());
        tsunami.setText(str);

    }

}
