package com.example.www;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 15-4-23.
 */
public class spinner extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        final Spinner sp = (Spinner)findViewById(R.id.spinner);
        ((Button)findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectID= ((Cell)((Spinner)findViewById(R.id.spcity)).getSelectedItem()).ID;
                String selectText= ((Cell)((Spinner)findViewById(R.id.spcity)).getSelectedItem()).Text;
                Toast.makeText(getApplicationContext(),"选择的项ID是："+selectID+"文本："+selectText,Toast.LENGTH_SHORT).show();
            }
        });

        final Cell[][] cells = {
                {new Cell("1","合肥"),new Cell("2","巢湖")},
                {new Cell("3","济南"),new Cell("4","青岛")},
                {new Cell("5","开封"),new Cell("6","太原")}
        };

        final String[][] citys = {
                {"合肥","巢湖","安庆","黄山","马鞍山","芜湖"},
                {"济南","青岛","烟台","日照"},
                {"开封","太原","石家庄"}
        };


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                ArrayAdapter<Cell> citylist = new ArrayAdapter<Cell>(getApplicationContext(),android.R.layout.simple_spinner_item,cells[i]);
                ((Spinner)findViewById(R.id.spcity)).setAdapter(citylist);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"未选择",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class Cell
    {
        public String ID;
        public String Text;
        public Cell(String _ID,String _Text)
        {
            ID=_ID;
            Text= _Text;
        }

        public String toString()
        {
            return Text;
        }
    }
}