package com.example.yuanxj.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends ActionBarActivity {

    private List<ListViewItem> m_arrayListItems = new ArrayList<ListViewItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //  contents
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));
        m_arrayListItems.add(new ListViewItem("0000000", R.drawable.itemicon));

        ListViewAdaptor adapter = new ListViewAdaptor(this, R.layout.list_view_item, m_arrayListItems);
        ListView xListView = (ListView)findViewById(R.id.listview_main);
        xListView.setAdapter(adapter);

        //  set listener
        xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = ListViewActivity.this.m_arrayListItems.get(position);
                Toast.makeText(ListViewActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
}
