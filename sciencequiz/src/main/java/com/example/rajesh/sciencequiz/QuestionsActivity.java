package com.example.rajesh.sciencequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Inertia of a body depends on?",
                            "Newton’s III law is applicable?",
                            "Power of lens is -4D, then its focal length is?",
                            "The eye defect ‘presbyopia’ can be corrected by?",
                            "If a substance is heated or cooled, the change in mass of that substance is?",
                            "Temperature is the average ________ of the molecules of a substance?",
                            "SI unit of resistance is?",
                            "Kilowatt hour is the unit of ?",
                            "When a sound wave travels through air, the air particles ",
                            "The frequency, which is audible to the human ear is ?",
                            "Unit of radioactivity is ",
                            "Artificial radioactivity was discovered by ",
                            "Mass of 1 mole of Nitrogen atom is",
                            "In the nucleus of 20Ca40, there are",
                            "The number of periods and groups in the periodic table are",
                            "Which of the following have inert gases 2 electrons in the outermost shell",
                            "A solution is a _______ mixture",
                            "Identify the non aqueous solution",
            "H2g + Cl2g -> 2HClg is a",
            "Photolysis is a decomposition reaction caused by ________",
            "The molecular formula of an open chain organic compound is C3H6. The class of the compound is",
            "Which of the following are used as anaesthetics?",
            "Rectified spirit is an aqueous solution which contains about _________ of ethanol",
            "Casparian strips are present in the ________ of the root",
            "The endarch condition is the characteristic feature of",
            "Oxygen is produced at what point during photosynthesis?",
            "The segments of leech are known as ",
            "Mammals are _______ animals.",
            "During transpiration there is loss of",
            "The wall of human heart is made of",
            "Bipolar neurons are found in",
            "Site for processing of vision, hearing, memory, speech, intelligence and thought is",
            "The hormone which has positive effect on apical dominance is",
            "To increase the sugar production in sugarcanes they are sprayed with ________.",
            "The plant which propagates with the help of its leaves is _________",
            "The essential parts of a flower are _________",
            "According to Mendel alleles have the following character",
            "9 :3 : 3 :1 ratio is due to",
            "The use and disuse theory was proposed by",
            "Paleontologists deal with",
            "We can cut the DNA with the help of",
            "Organisms with modified endogenous gene or a foreign gene are also known as ",
            "World No Tobacco Day is observed on",
            "Which type of cancer affects lymph nodes and spleen?",
            "Green house effect refers to",
            "An inexhaustible resources is",
            "Which software is used to create animation?",
            "All files are stored in the",
            "Syngamy results in the formation of ",
            "The centromere is found at the centre of the _________ chromosome",


                         };
    String answers[] = {"Mass of the object","Both a & b","-0.25m","Bi focal lenses","Zero","Difference in T.E and P.E",
                              "Ohm","Electrical energy","Vibrate along the direction of the wave motion","20 kHz","All the above","Irene curie","28 g",
                        "20 protons and 20 neutrons","7,18","He","Homogeneous","Sulphur in carbon di sulphide","Combination reaction","Light","Alkene",
            "Ethers","95.5 %","Endodermis","Stem","When H2O is splitted","Metameres (somites)","Warm blooded","Water","All of the above","Retina of eye",
            "Brain","Auxin","Gibberellins","Bryophyllum","Androecium and gynoecium","Responsible for character","Independent assortment","Jean baptiste Lamarck",
            "Fossil evidences","Restriction endonucleases","Both a and b","May 31","Lymphoma","Warming of earth","Wind power","Scratch","Folder",
            "Zygote","Metacentric",
    };
    String opt[] = {
                    "Weight of the object","Acceleration due to gravity of the planet","Mass of the object","Both a & b",
                    "For a body is at rest","For a body in motion","Both a & b","Only for bodies with equal masses",
                    "4m","-40m","-0.25m","-2.5m",
                    "Convex lens","Concave lens","Convex mirror","Bi focal lenses",
                    "Positive","Negative","Zero","None of the above",
                    "Difference in K.E and P.E","Sum of P.E and K.E","Difference in T.E and P.E","Difference in K.E and T.E",
                    "Mho","Joule","Ohm","Ohm meter",
                    "Resistivity","Electrical power","Conductivity", "Electrical energy",
                    "Vibrate along the direction of the wave motion ","Vibrate but not in any fixed direction"," Vibrate perpendicular to the direction of the wave motion"," Do not vibrate",
                    "50 kHz ","20 kHz","15000 kHz" ,"10000 kHz",
                    "Roentgen","Curie","Becquerel","All the above",
                    "Becquerel","Irene curie","Roentgen","Neils bohr",
                    "28 amu","14 amu","28 g","14 g",
                    "20 protons and 40 neutrons","20 protons and 20 neutrons","20 protons and 40 electrons","20 protons and 20 electrons",
                    "7,18","7,17","8,18","6,16",
                    "He","Ne","Ar","Kr",
                    "Homogeneous","Heterogeneous","Homogeneous and heterogeneous","Non homogeneous",
                    "Sodium chloride in water","Glucose in water","Copper sulphate in water","Sulphur in carbon di sulphide",
            "Decomposition reaction","Combination reaction","Single displacement reaction","Double displacement reaction",
            "Heat","Electricity","Light","Mechanical energy",
            "Alkane","Alkene","Alkyne","Alcohol",
            "Carboxylic acids","Ethers","Esters","Aldehydes",
            "95.5 %","75.5 %","55.5 %","45.5 %",
            "Cortex","Pith","Pericycle","Endodermis",
            "Root","Stem","Leaves","Flower",
            "When ATP is converted to ADP","When CO2 is fixed","When H2O is splitted","All of these",
            "Metameres (somites)","Proglottids","Strobiia","All the above",
            "Cold blooded","Warm blooded","Poikilothermic","All the above",
            "Carbon dioxide","Oxygen","Water","None of the above",
            "Endocardium","Epicardium","Myocardium","All of the above",
            "Retina of eye","Cerebral cortex","Embryo","Respiratory epithelium",
            "Kidney","Ear","Brain","Lungs",
            "Cytokinin","Auxin","Gibberellins","Ethylene",
            "Auxin","Cytokinin", "Gibberellins","Ethylene",
            "Onion","Neem","Ginger","Bryophyllum",
            "Calyx and corolla","Calyx and androecium","Corolla and gynoecium","Androecium and gynoecium",
            "Pair of genes","Responsible for character","Production of gametes","Recessive factors",
            "Segregation","Crossing over","Independent assortment","Recessiveness",
            "Charles Darwin","Enrst Haeckel","Jean baptiste Lamarck","Gregor mendel",
            "Embryological evidences","Fossil evidences","Vestigial organ evidences","All the above",
            "Scissors","Restriction endonucleases","Knife","RNAase",
            "Transgenic organisms","Genetically modified","Mutated","Both a and b",
            "May 31","June 6","April 22","October 2",
            "Carcinoma","Sarcoma","Leukemia","Lymphoma",
            "Cooling of earth","Trapping of UV rays","Cultivation of plants","Warming of earth",
            "Wind power","Soil fertility","Wild life","All of the above",
            "Paint","PDF","MS Word","Scratch",
            "Folder","Box","Pai","Scanner",
            "Zoospores","Conidia","Zygote","Chlamydospores",
            "Telocentric","Metacentric","Sub–metacentric","Acrocentric",


};
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}