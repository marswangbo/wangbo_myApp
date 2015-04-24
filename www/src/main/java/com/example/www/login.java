package com.example.www;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 15-4-23.
 */
public class login extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ((Button)findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this,"点击了登录按钮:用户名("+((TextView)findViewById(R.id.txtUser)).getText().toString()+")",Toast.LENGTH_SHORT).show();
            }
        });

        ((Button)findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}