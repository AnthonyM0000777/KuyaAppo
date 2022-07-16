package com.cite.newscoopup;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicalNeeds extends AppCompatActivity {

    TextView fire;
    String str =
            "\nWhat to do Before a Wildfire\n\n"+
                    "* Create defensible space to separate your home from flammable vegetation and materials (minimum 30 ft)\n\n" +
                    "* Adhere to all local fire and building codes and weed abatement ordinances.\n\n"+
                    "* Keep all trees and shrub limbs trimmed so they do not come into contact with electrical wires or overhang your chimney (Do not trim around power lines yourself, call a professional).\n\n"+
                    "* Prune all lower branches 8 feet from the ground.\n\n"+
                    "* Stack firewood away from your home and other buildings (Keep clearance around your piles).\n\n"+
                    "* Keep trees adjacent to buildings free of dead or dying branches.\n\n"+
                    "* Keep roof surfaces clear of pine needles, leaves and debris at all times.\n\n"+
                    "* Clean chimneys and check and maintain spark arresters twice a year.\n\n"+
                    "* Keep rain gutters clear of debris at all times.\n\n"+
                    "* Use approved fire resistant materials when building, renovating or retrofitting structures.\n\n"+
                    "* Be sure your house numbers show clearly from the street, both day and night.\n\n"+
                    "* Store all important papers in a fireproof container or keep copies at another location.\n\n"+
                    "* Store combustible or flammable materials in approved containers.\n\n"+
                    "* Keep battery operated radios and flashlights with additional fresh batteries on hand.\n\n"+
                    "* Make evacuation plans with family members. Include several options with an outside meeting place and contact person. Practice regularly."+
                    "\n\n\n"+
                    "What to do During a Wildfire\n\n"+
                    "* Turn on a TV or radio to get the latest emergency information\n\n"+
                    "* If you have a ladder, prop it against the house so you and firefighters have access to roof.\n\n"+
                    "* If hoses and adequate water are available set them up. Fill buckets with water.\n\n"+
                    "* Remove combustible material from the area surrounding the house (lawn chairs, tables, etc.).\n\n"+
                    "* Turn a light on in each room for visibility in case of smoke.\n\n"+
                    "* Open or take down flammable drapes and curtains.\n\n"+
                    "* Move upholstered furniture away from windows and sliding glass doors.\n\n"+
                    "* Be ready to evacuate all family members and pets when requested to do so.\n\n"+
                    "* Turn off air conditioning/air circulation systems\n\n"+
                    "* Detach electrical garage doors. Back in your car and leave the keys in the ignition.\n\n"+
                    "* Secure your pets if possible."+
                    "\n\n\n"+
                    "What to do After a Wildfire\n\n"+
                    "* Check with fire officials before attempting to return to your home.\n\n" +
                    "* Use caution when re-entering a burned area - flare ups can occur.\n\n"+
                    "* Check grounds for hot spots, smoldering stumps and vegetation. Use your buckets of water.\n\n"+
                    "* Check the roof and exterior areas for sparks and embers.\n\n"+
                    "* Check the attic and throughout the house for hidden burning, sparks and embers.\n\n"+
                    "* Continue to check for problem areas for several days.\n\n\n"+
                    "* Contact 911 if any danger is perceived."+
                    "\n\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_medical_needs);


        fire = findViewById(R.id.text6);

        loadText();
    }

    private void loadText(){

        fire.setMovementMethod(new ScrollingMovementMethod ());
        fire.setText(str);

    }

}