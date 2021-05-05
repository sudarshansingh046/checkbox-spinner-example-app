package com.example.checkbox_spinner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import com.example.checkbox_spinner.Others.AppData;

public class MainActivity extends Activity {
    LinearLayout lin_layout_main;
    CheckBox cb_android, cb_iphone;
    Button btn_show, btn_next ;
    RadioGroup radio_group ;
    RadioButton radioBtn_red, radioBtn_green, radioBtn_blue;
    String item_main = "None" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        lin_layout_main = (LinearLayout)findViewById(R.id.lin_layout_main);
        //cb_android=(CheckBox)findViewById(R.id.cb_android);
        cb_android = (CheckBox) findViewById(R.id.cb_android);
        cb_iphone = (CheckBox) findViewById(R.id.cb_iphone);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_next = (Button) findViewById(R.id.btn_next);
        radio_group = (RadioGroup) findViewById(R.id.radioGroup);
        radioBtn_red = (RadioButton) findViewById(R.id.radioBtn_Red);
        radioBtn_green = (RadioButton) findViewById(R.id.radioBtn_Green);
        radioBtn_blue = (RadioButton) findViewById(R.id.radioBtn_Blue);
        //Code for CheckBoxes inside Button's OnClickListener class:
        //-----------------------------------------------------------
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cb_android.isChecked()==true && cb_iphone.isChecked()==false)
                {
                    Toast.makeText(MainActivity.this, "Android",
                            Toast.LENGTH_LONG).show();
                }
                else if(cb_iphone.isChecked()==true&&cb_android.isChecked()==false)
                {
                    Toast.makeText(MainActivity.this, "Iphone",
                            Toast.LENGTH_LONG).show();
                }
                else if(cb_android.isChecked()==true&&cb_iphone.isChecked()==true ) {
                    Toast.makeText(MainActivity.this,
                            "Android & Iphone", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,
                            "Nothing is selected", Toast.LENGTH_LONG).show();
            }
        });
        //Code for RadioButton views:
        if(AppData.status == "Red")
        {
            radioBtn_red.setChecked(true);
            lin_layout_main.setBackgroundColor(Color.parseColor
                    ("#FF0000"));
            item_main = "Red";
        }
        else if (AppData.status == "Green")
        {
            radioBtn_green.setChecked(true);
            lin_layout_main.setBackgroundColor(Color.parseColor
                    ("#008000"));
            item_main = "Green";
        }
        else if (AppData.status == "Blue")
        {
            radioBtn_blue.setChecked(true);
            lin_layout_main.setBackgroundColor(Color.parseColor
                    ("#0000FF"));
            item_main = "Blue";
        }

        radio_group.setOnCheckedChangeListener
                (new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int arg1) {
                        if(R.id.radioBtn_Red == arg1)
                        {
                            lin_layout_main.setBackgroundColor(Color.parseColor
                                    ("#FF0000"));
                            item_main = "Red";
                        }
                        else if (R.id.radioBtn_Green == arg1)
                        {
                            lin_layout_main.setBackgroundColor(Color.parseColor
                                    ("#008000"));
                            item_main = "Green";
                        }
                        else if (R.id.radioBtn_Blue == arg1)
                        {
                            lin_layout_main.setBackgroundColor(Color.
                                    parseColor("#0000FF"));
                            item_main = "Blue";
                        }
                    }
                });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(MainActivity.this, Spin.class);
                i.putExtra("key_main", item_main);
                startActivity(i);
                finish();
            }
        });
    }



}
