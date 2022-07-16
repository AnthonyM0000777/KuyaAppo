package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserLandslide extends AppCompatActivity {



    TextView landslide;
    String str =
            "\nWhat To Do Before a Landslide\n\n"+
            "* Do not build near steep slopes, close to mountain edges, near drainage ways, or natural erosion valleys.\n\n"+
            "* Get a ground assessment of your property.\n\n"+
            "* Contact local officials, state geological surveys or departments of natural resources, and university departments of geology. Landslides occur where they have before, and in identifiable hazard locations. Ask for information on landslides in your area, specific information on areas vulnerable to landslides, and request a professional referral for a very detailed site analysis of your property, and corrective measures you can take, if necessary.\n\n\n"+
            "* Watch the patterns of storm-water drainage near your home, and note the places where runoff water converges, increasing flow in channels. These are areas to avoid during a storm.\n\n"+
            "* Learn about the emergency-response and evacuation plans for your area. Develop your own emergency plan for your family or business.\n\n"+
            "* Minimize home hazards:\n" +
                    "- Have flexible pipe fittings installed to avoid gas or water leaks, as flexible fittings are more resistant to breakage (only the gas company or professionals should install gas fittings).\n" +
                    "- Plant ground cover on slopes and build retaining walls.\n" +
                    "- In mudflow areas, build channels or deflection walls to direct the flow around buildings. Remember: If you build walls to divert debris flow and the flow lands on a neighbor's property, you may be liable for damages.\n\n"+
            "\n\n\n"+
            "What To Do During a Landslide\n\n"+
            "* Stay alert and awake. Many debris-flow fatalities occur when people are sleeping. Listen to a NOAA Weather Radio or portable, battery-powered radio or television for warnings of intense rainfall. Be aware that intense, short bursts of rain may be particularly dangerous, especially after longer periods of heavy rainfall and damp weather.\n\n"+
            "* If you are in areas susceptible to landslides and debris flows, consider leaving if it is safe to do so. Remember that driving during an intense storm can be hazardous. If you remain at home, move to a second story if possible. Staying out of the path of a landslide or debris flow saves lives.\n\n"+
            "* Listen for any unusual sounds that might indicate moving debris, such as trees cracking or boulders knocking together. A trickle of flowing or falling mud or debris may precede larger landslides. Moving debris can flow quickly and sometimes without warning.\n\n"+
            "* If you are near a stream or channel, be alert for any sudden increase or decrease in water flow and for a change from clear to muddy water. Such changes may indicate landslide activity upstream, so be prepared to move quickly. Don't delay! Save yourself, not your belongings.\n\n"+
            "* Be especially alert when driving. Bridges may be washed out, and culverts overtopped. Do not cross flooding streams!! Turn Around, Don't Drown®!. Embankments along roadsides are particularly susceptible to landslides. Watch the road for collapsed pavement, mud, fallen rocks, and other indications of possible debris flows.\n\n"+
            "* Be aware that strong shaking from earthquakes can induce or intensify the effects of landslides."+
            "\n\n\n"+
            "What To Do After a Landslide\n\n"+
            "* Stay away from the slide area. There may be danger of additional slides.\n\n" +
            "* Listen to local radio or television stations for the latest emergency information.\n\n"+
            "* Watch for flooding, which may occur after a landslide or debris flow. Floods sometimes follow landslides and debris flows because they may both be started by the same event.\n\n"+
            "* Check for injured and trapped persons near the slide, without entering the direct slide area. Direct rescuers to their locations.\n\n"+
            "* Help a neighbor who may require special assistance - infants, elderly people, and people with disabilities. Elderly people and people with disabilities may require additional assistance. People who care for them or who have large families may need additional assistance in emergency situations.\n\n"+
            "* Look for and report broken utility lines and damaged roadways and railways to appropriate authorities. Reporting potential hazards will get the utilities turned off as quickly as possible, preventing further hazard and injury.\n\n"+
            "* Check the building foundation, chimney, and surrounding land for damage. Damage to foundations, chimneys, or surrounding land may help you assess the safety of the area.\n\n"+
            "* Replant damaged ground as soon as possible since erosion caused by loss of ground cover can lead to flash flooding and additional landslides in the near future.\n\n"+
            "* Seek advice from a geotechnical expert for evaluating landslide hazards or designing corrective techniques to reduce landslide risk. A professional will be able to advise you of the best ways to prevent or reduce landslide risk, without creating further hazard."+
            "\n\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_user_landslide);


        landslide = findViewById(R.id.text3);

        loadText();
    }

    private void loadText(){

        landslide.setMovementMethod(new ScrollingMovementMethod());
        landslide.setText(str);

    }

}
