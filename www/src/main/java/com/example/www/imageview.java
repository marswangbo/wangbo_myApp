package com.example.www;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 15-4-24.
 */
public class imageview extends Activity {
    private Integer[] image = { R.drawable.a , R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e };
    private  Integer currentID = 0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        ImageView img = (ImageView)findViewById(R.id.image);
        img.setImageResource(image[0]);
        ((Button) findViewById(R.id.btnPre)).setOnClickListener(new PreClick());
        ((Button)findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            //private  int x = 0;
            public void onClick(View view) {
                if(currentID<4)
                {
                    ((ImageView)findViewById(R.id.image)).setImageResource(image[++currentID]);
                }
                else if(currentID==4)
                {
                    ((ImageView)findViewById(R.id.image)).setImageResource(image[0]);
                    currentID=0;
                }
                //currentID=Integer.valueOf(x);
                Toast.makeText(getApplicationContext(),String.valueOf(currentID),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class PreClick implements View.OnClickListener
    {
        //int i = 4;
        @Override
        public void onClick(View view) {
            if(currentID>0)
            {
                ((ImageView)findViewById(R.id.image)).setImageResource(image[--currentID]);
            }
            else if(currentID==0)
            {
                ((ImageView)findViewById(R.id.image)).setImageResource(image[4]);
                currentID=4;
            }
            Toast.makeText(getApplicationContext(),String.valueOf(currentID),Toast.LENGTH_SHORT).show();
        }
    }
}