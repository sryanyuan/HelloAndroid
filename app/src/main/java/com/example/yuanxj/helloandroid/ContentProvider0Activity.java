package com.example.yuanxj.helloandroid;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ContentProvider0Activity extends ActionBarActivity {

    private List<String> m_refStringList = new ArrayList<String>();
    private ArrayAdapter<String> m_refAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider0);

        ListView refListView = (ListView)findViewById(R.id.listview_content);
        if(null != refListView){
            m_refAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, m_refStringList);
            refListView.setAdapter(m_refAdapter);
            readContents();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content_provider0, menu);
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

    private void readContents(){
        Cursor refCursor = null;

        try{
            refCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            while(refCursor.moveToNext()){
                String refDisplayName = refCursor.getString(refCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String refNumber = refCursor.getString(refCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                m_refStringList.add(refDisplayName + "\n" + refNumber);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
