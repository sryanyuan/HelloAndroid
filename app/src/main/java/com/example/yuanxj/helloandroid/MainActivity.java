package com.example.yuanxj.helloandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    final String m_LogTag = "";
    protected double m_fLastClickBackTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //  initialize fields
        m_fLastClickBackTime = 0;

        //  load system info
        updateCpuUsage();

        //  set button listener
        Button buttonRefresh = (Button)findViewById(R.id.button_refresh);
        if(null != buttonRefresh){
            buttonRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "refresh", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:11111"));
                    startActivity(intent);
                }
            });
        }

        Button buttonFinish = (Button)findViewById(R.id.button_finish);
        if(null != buttonFinish) buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        Button buttonSwitch = (Button)findViewById(R.id.button_switch);
        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder xDlgBuilder = new AlertDialog.Builder(MainActivity.this);
                xDlgBuilder.setTitle("question?");
                xDlgBuilder.setMessage("switch to sec activity?");
                xDlgBuilder.setCancelable(false);
                xDlgBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText)findViewById(R.id.editText_name);
                        Intent intent = new Intent(MainActivity.this, SecActivity.class);
                        String content = editText.getText().toString();
                        Log.d(m_LogTag, content);
                        intent.putExtra("name", content);
                        startActivity(intent);
                    }
                });
                xDlgBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                xDlgBuilder.show();
            }
        });

        Button buttonListView = (Button)findViewById(R.id.button_list_view);
        if(null != buttonListView){
            buttonListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            //  double click to exit
            double fClickTime = System.currentTimeMillis();
            if(fClickTime - m_fLastClickBackTime > 2000){
                Toast.makeText(this, "返回2次退出", Toast.LENGTH_SHORT).show();
                m_fLastClickBackTime = fClickTime;
            }else{
                finish();
            }

            return false;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }

    protected int getCpuUsage(){

        return -1;
    }

    protected boolean updateCpuUsage(){
        int nCpuUsage = getCpuUsage();
        if(-1 != nCpuUsage){
            TextView labelCpuUsage = (TextView)findViewById(R.id.textView_cpuUsage);
            if(null != labelCpuUsage){
                labelCpuUsage.setText(Integer.toString(nCpuUsage));
                return true;
            }
        }

        return false;
    }
}
