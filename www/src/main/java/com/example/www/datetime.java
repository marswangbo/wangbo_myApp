package com.example.www;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Administrator on 15-4-24.
 */
public class datetime extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datatime);
        final DatePicker datePicker = (DatePicker)findViewById(R.id.date);

        ((Button)findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"年"+datePicker.getYear()+"月"+ (datePicker.getMonth()+1)+"日"+datePicker.getDayOfMonth(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}