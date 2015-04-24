package com.example.www;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 15-4-23.
 */
public class radioAndCheckBox extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radioandcheckbox);
        final RadioGroup rd = (RadioGroup)findViewById(R.id.radGroup);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                String fav = "";
                if(((CheckBox)findViewById(R.id.chkBaskBall)).isChecked()) fav+=((CheckBox)findViewById(R.id.chkBaskBall)).getText();
                if(((CheckBox)findViewById(R.id.chkFootBall)).isChecked()) fav+=((CheckBox)findViewById(R.id.chkFootBall)).getText();
                Toast.makeText(radioAndCheckBox.this,"选中的项："+((RadioButton)radioGroup.findViewById(i)).getText()+"/爱好："+fav,Toast.LENGTH_SHORT).show();
            }
        });



        ((Button)findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(radioAndCheckBox.this, "选中的选项是：" + ((RadioButton) findViewById(rd.getCheckedRadioButtonId())).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}