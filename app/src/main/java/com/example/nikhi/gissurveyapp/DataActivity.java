package com.example.nikhi.gissurveyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.defaultValue;
import static com.example.nikhi.gissurveyapp.R.id.ll1;

public class DataActivity extends AppCompatActivity {
    TextView tv;
    Spinner spin;
    Button btn;
    Double converted_x;
    Double converted_y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv=(TextView)findViewById(R.id.textView);
        spin=(Spinner)findViewById(R.id.spinner);
        btn=(Button)findViewById(R.id.test);
        ArrayList<String> s=getIntent().getStringArrayListExtra("result_details");
        converted_x=getIntent().getDoubleExtra("converted_x",defaultValue);
        converted_y=getIntent().getDoubleExtra("converted_y",defaultValue);
        Toast.makeText(DataActivity.this,converted_x.toString()+"   "+converted_y.toString(),Toast.LENGTH_SHORT).show();

        tv.setText("Location Address"+System.getProperty("line.separator")+s.get(0)+"  "+s.get(1)+"   "+s.get(2));
        tv.setGravity(Gravity.CENTER);

        //CREATING THE SUBMIT BUTTON HERE TO SUBMIT THE RATRING EDITS
                LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //CREATING THE SUBMIT BUTTON HERE TO SUBMIT THE RATRING EDITS
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String rating_select=spin.getSelectedItem().toString();
                        LinearLayout linear=(LinearLayout)findViewById(ll1);
                        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


                //RATINNG 0
                CheckBox cb1 = new CheckBox(DataActivity.this);
                cb1.setLayoutParams(lparams);
                cb1.setText("Sweeper has passed through Alley");

               //RATING 1
                CheckBox cb2 = new CheckBox(DataActivity.this);
                cb2.setLayoutParams(lparams);
                cb2.setText("Overgrowth Removed");

                CheckBox cb3 = new CheckBox(DataActivity.this);
                cb3.setLayoutParams(lparams);
                cb3.setText("Alley Passable");

                CheckBox cb4 = new CheckBox(DataActivity.this);
                cb4.setLayoutParams(lparams);
                cb4.setText("Debris and Litter Removed");

                CheckBox cb5 = new CheckBox(DataActivity.this);
                cb5.setLayoutParams(lparams);
                cb5.setText("No Illegal Dumping");

                CheckBox cb6 = new CheckBox(DataActivity.this);
                cb6.setLayoutParams(lparams);
                cb6.setText("No bulk Items");

                CheckBox cb7 = new CheckBox(DataActivity.this);
                cb7.setLayoutParams(lparams);
                cb7.setText("No Abandoned Vehicles");

                CheckBox cb8 = new CheckBox(DataActivity.this);
                cb8.setLayoutParams(lparams);
                cb8.setText("No Illegal Parking");

                //RATING 2

                CheckBox cb9 = new CheckBox(DataActivity.this);
                cb9.setLayoutParams(lparams);
                cb9.setText("Canopy Cutback");
                CheckBox cb10 = new CheckBox(DataActivity.this);
                cb10.setLayoutParams(lparams);
                cb10.setText("Overgrowth Removed");
                CheckBox cb11 = new CheckBox(DataActivity.this);
                cb11.setLayoutParams(lparams);
                cb11.setText("Alley Passable");
                CheckBox cb12 = new CheckBox(DataActivity.this);
                cb12.setLayoutParams(lparams);
                cb12.setText("Debris and Litter Removed");
                CheckBox cb13 = new CheckBox(DataActivity.this);
                cb13.setLayoutParams(lparams);
                cb13.setText("No Illegal Dumping");
                CheckBox cb14 = new CheckBox(DataActivity.this);
                cb14.setLayoutParams(lparams);
                cb14.setText("No Bulk Items");
                CheckBox cb15 = new CheckBox(DataActivity.this);
                cb15.setLayoutParams(lparams);
                cb15.setText("No Abondoned Vehicles");
                CheckBox cb16 = new CheckBox(DataActivity.this);
                cb16.setLayoutParams(lparams);
                cb16.setText("No Illegal Parking");

                //Rating 3
                CheckBox cb17 = new CheckBox(DataActivity.this);
                cb17.setLayoutParams(lparams);
                cb17.setText("Canopy Cutback");
                CheckBox cb18 = new CheckBox(DataActivity.this);
                cb18.setLayoutParams(lparams);
                cb18.setText("Overgrowth Removed");
                CheckBox cb19 = new CheckBox(DataActivity.this);
                cb19.setLayoutParams(lparams);
                cb19.setText("Alley Passable");
                CheckBox cb20 = new CheckBox(DataActivity.this);
                cb20.setLayoutParams(lparams);
                cb20.setText("Debris and Litter Removed");
                CheckBox cb21 = new CheckBox(DataActivity.this);
                cb21.setLayoutParams(lparams);
                cb21.setText("Bulk Items Collected");
                CheckBox cb22 = new CheckBox(DataActivity.this);
                cb22.setLayoutParams(lparams);
                cb22.setText("Illegal Dumping Cleared");
                CheckBox cb23 = new CheckBox(DataActivity.this);
                cb23.setLayoutParams(lparams);
                cb23.setText("No Abondoned Vehicles");
                CheckBox cb24 = new CheckBox(DataActivity.this);
                cb24.setLayoutParams(lparams);
                cb24.setText("No Illegal Parking");

                //RATING 4

                CheckBox cb25 = new CheckBox(DataActivity.this);
                cb25.setLayoutParams(lparams);
                cb25.setText("Overgrowth Removed");
                CheckBox cb26 = new CheckBox(DataActivity.this);
                cb26.setLayoutParams(lparams);
                cb26.setText("Alley Moderately Passable");
                CheckBox cb27 = new CheckBox(DataActivity.this);
                cb27.setLayoutParams(lparams);
                cb27.setText("Debris and Litter Removed");
                CheckBox cb28 = new CheckBox(DataActivity.this);
                cb28.setLayoutParams(lparams);
                cb28.setText("Bulk Items Collected");
                CheckBox cb29 = new CheckBox(DataActivity.this);
                cb29.setLayoutParams(lparams);
                cb29.setText("Illegal Dumping Cleared");
                CheckBox cb30 = new CheckBox(DataActivity.this);
                cb30.setLayoutParams(lparams);
                cb30.setText("No Abondoned Vehicle");
                CheckBox cb31 = new CheckBox(DataActivity.this);
                cb31.setLayoutParams(lparams);
                cb31.setText("No Illegal Parking");

                //RATING 5

                CheckBox cb32 = new CheckBox(DataActivity.this);
                cb32.setLayoutParams(lparams);
                cb32.setText("Overgrowth removed");
                CheckBox cb33 = new CheckBox(DataActivity.this);
                cb33.setLayoutParams(lparams);
                cb33.setText("Alley Passable");
                CheckBox cb34 = new CheckBox(DataActivity.this);
                cb34.setLayoutParams(lparams);
                cb34.setText("Debris and Litter Removed");
                CheckBox cb35 = new CheckBox(DataActivity.this);
                cb35.setLayoutParams(lparams);
                cb35.setText("Bulk Items Collected");
                CheckBox cb36 = new CheckBox(DataActivity.this);
                cb36.setLayoutParams(lparams);
                cb36.setText("Illegal Dumping Cleared");
                CheckBox cb37 = new CheckBox(DataActivity.this);
                cb37.setLayoutParams(lparams);
                cb37.setText("Abondoned Vehicles Removed");
                CheckBox cb38 = new CheckBox(DataActivity.this);
                cb38.setLayoutParams(lparams);
                cb38.setText("Illegally Parked Vehicles Towed");

                //RATING 6
                CheckBox cb39 = new CheckBox(DataActivity.this);
                cb39.setLayoutParams(lparams);
                cb39.setText("Overgrowth Removed");
                CheckBox cb40 = new CheckBox(DataActivity.this);
                cb40.setLayoutParams(lparams);
                cb40.setText("Weeds Removed");
                CheckBox cb41 = new CheckBox(DataActivity.this);
                cb41.setLayoutParams(lparams);
                cb41.setText("Debris and Litter Removed");
                CheckBox cb42 = new CheckBox(DataActivity.this);
                cb42.setLayoutParams(lparams);
                cb42.setText("Bulk Items Collected");
                CheckBox cb43 = new CheckBox(DataActivity.this);
                cb43.setLayoutParams(lparams);
                cb43.setText("Illegally Dumping Cleared");
                CheckBox cb44 = new CheckBox(DataActivity.this);
                cb44.setLayoutParams(lparams);
                cb44.setText("Abondoned Vehicles Removed");
                CheckBox cb45 = new CheckBox(DataActivity.this);
                cb45.setLayoutParams(lparams);
                cb45.setText("Illegally Parked Vehicles Towed");


                switch(rating_select) {
                    case "0-No Overgrowth,Alley Passable":
                       Toast.makeText(DataActivity.this,"0",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb1);

                        break;
                    case "1-Low Overgrowth,Alley Passable":
                        Toast.makeText(DataActivity.this,"1",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb2);
                        linear.addView(cb3);
                        linear.addView(cb4);
                        linear.addView(cb5);
                        linear.addView(cb6);
                        linear.addView(cb7);
                        linear.addView(cb8);


                        break;
                    case "2-Dense High Overgrowth,Alley Passable,No Bulking Items":
                        Toast.makeText(DataActivity.this,"2",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb9);
                        linear.addView(cb10);
                        linear.addView(cb11);
                        linear.addView(cb12);
                        linear.addView(cb13);
                        linear.addView(cb14);
                        linear.addView(cb15);
                        linear.addView(cb16);

                        break;
                    case "3-Dense High Overgrowth,Alley Passable,Minor Bulk Items":
                        Toast.makeText(DataActivity.this,"3",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb17);
                        linear.addView(cb18);
                        linear.addView(cb19);
                        linear.addView(cb20);
                        linear.addView(cb21);
                        linear.addView(cb22);
                        linear.addView(cb23);
                        linear.addView(cb24);

                        break;
                    case "4-Moderate to Dense Overgrowth,Alley Moderately Passable,Large Bulk Items Present":
                        Toast.makeText(DataActivity.this,"4",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb25);
                        linear.addView(cb26);
                        linear.addView(cb27);
                        linear.addView(cb28);
                        linear.addView(cb29);
                        linear.addView(cb30);
                        linear.addView(cb31);


                        break;
                    case "5-Serious Overgrowth, Impassable Alley":
                        Toast.makeText(DataActivity.this,"5",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb32);
                        linear.addView(cb33);
                        linear.addView(cb34);
                        linear.addView(cb35);
                        linear.addView(cb36);
                        linear.addView(cb37);
                        linear.addView(cb38);

                        break;
                    case "6-Unimproved Alley":
                        Toast.makeText(DataActivity.this,"6",Toast.LENGTH_SHORT).show();
                        linear.removeAllViews();
                        linear.addView(cb39);
                        linear.addView(cb40);
                        linear.addView(cb41);
                        linear.addView(cb42);
                        linear.addView(cb43);
                        linear.addView(cb44);
                        linear.addView(cb45);

                        break;
                    case "Select Alley Rating":
                        linear.removeAllViews();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(spin.getSelectedItem().toString()!="Select Alley Rating")
               {
                   Toast.makeText(DataActivity.this,"Submitting Edits",Toast.LENGTH_SHORT).show();
                   String alley_rating=spin.getSelectedItem().toString();

               }
                  if(spin.getSelectedItem().toString()=="Select Alley Rating")
                  {
                      Toast.makeText(DataActivity.this,"Select Alley Rating to perform edits",Toast.LENGTH_SHORT).show();
                  }
           }
       });
    }

}
