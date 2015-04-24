package com.example.www;

/*
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        for(int i = 0;i<3;i++)
        {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(5*(i+1),128);
            params.setMargins(0,0,1,1);

            TextView textView = new TextView(this);
            textView.setLines(1);
            textView.setText(String.valueOf(i));
            textView.setBackgroundColor(Color.BLACK);
            addContentView(textView, params);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
*/

import java.util.ArrayList;
import com.example.www.TableAdapter.TableCell;
import com.example.www.TableAdapter.TableRow;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
/**
 * @author hellogv
 */
public class main extends Activity {
    /** Called when the activity is first created. */
    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("ListView自适应实现表格---hellogv");
        lv = (ListView) this.findViewById(R.id.ListView01);
        ArrayList<TableRow> table = new ArrayList<TableRow>();
        TableCell[] titles = new TableCell[2];// 每行5个单元
        int width = this.getWindowManager().getDefaultDisplay().getWidth()/titles.length;
        // 定义标题
        for (int i = 0; i < titles.length; i++) {
            titles[i] = new TableCell("标题" + String.valueOf(i),
                    width,//width + 8 * i,
                    LayoutParams.MATCH_PARENT,
                    TableCell.STRING);
        }
        table.add(new TableRow(titles));
        // 每行的数据
        TableCell[] cells = new TableCell[2];// 每行5个单元
        for (int i = 0; i < cells.length - 1; i++) {
            cells[i] = new TableCell("No." + String.valueOf(i),
                    titles[i].width,
                    LayoutParams.MATCH_PARENT,
                    TableCell.STRING);
        }
        cells[cells.length - 1] = new TableCell(R.drawable.ic_launcher,
                titles[cells.length - 1].width,
                LayoutParams.WRAP_CONTENT,
                TableCell.IMAGE);
        // 把表格的行添加到表格
        for (int i = 0; i < 12; i++)
            table.add(new TableRow(cells));
        TableAdapter tableAdapter = new TableAdapter(this, table);
        lv.setAdapter(tableAdapter);
        lv.setOnItemClickListener(new ItemClickEvent());
    }
    class ItemClickEvent implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
            if(arg2>0)
                Toast.makeText(main.this, "选中第"+String.valueOf(arg2)+"行", 500).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.addSubMenu(0,0,0,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 0:
                AlertDialog alertDialog = new AlertDialog.Builder(main.this).setMessage("是否退出？").setTitle("确认").setNegativeButton("取消",null).
                        setPositiveButton("确定",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.exit(0);
                            }
                        }).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}