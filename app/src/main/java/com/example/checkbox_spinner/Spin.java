package com.example.checkbox_spinner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.example.checkbox_spinner.Others.AppData;

public class Spin extends Activity {
    LinearLayout lin_layout_spin ;
    Button btn_back ;
    Spinner sp ;
    String[] col={"Red","Green","Blue"};
    String item_spin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item_spin = getIntent().getExtras().getString("key_main");
        setContentView(R.layout.spin);
        lin_layout_spin = (LinearLayout)findViewById(R.id.lin_layout_spin);
        btn_back = (Button)findViewById(R.id.btn_back);

        sp = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this , android.R.layout.simple_spinner_item , col);
        adapter.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        //Change layout background of spin.xml only if a radio button from activity_mail.xml is selected:
        int index = adapter.getPosition(item_spin);
        if (item_spin!="None")
        {
            sp.setSelection(index);
        }
        //Code for Spinner view:
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                item_spin = col[arg2];			//Alternate Code// item_spin = sp.getSelectedItem().toString();
                if(item_spin.equals("Red"))
                {
                    lin_layout_spin.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                else if(item_spin.equals("Green"))
                {
                    lin_layout_spin.setBackgroundColor(Color.parseColor("#008800"));
                }
                else if(item_spin.equals("Blue"))
                {
                    lin_layout_spin.setBackgroundColor(Color.parseColor("#0000FF"));
                }
             }
             @Override
             public void onNothingSelected(AdapterView<?> arg0) {
                                                 }
                                             });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AppData.status = item_spin ;
                Intent i = new Intent(Spin.this, MainActivity.class);
                startActivity(i);
                finish();
            }

        });

    }

}
