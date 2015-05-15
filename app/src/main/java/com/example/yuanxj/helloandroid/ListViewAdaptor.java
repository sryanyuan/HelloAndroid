package com.example.yuanxj.helloandroid;

import android.util.Log;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuanxj on 2015/5/5.
 */
public class ListViewAdaptor extends ArrayAdapter<ListViewItem> {

    private int textViewResourceId;

    public ListViewAdaptor(Context _ctx, int _textViewResourceId, List<ListViewItem> _objects){
        super(_ctx, _textViewResourceId, _objects);
        textViewResourceId = _textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewItem item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(textViewResourceId, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageview_listImage);
        TextView textView = (TextView)view.findViewById(R.id.textview_itemText);

        if(null == imageView){
            Log.e("ListViewAdaptor", "null imageView");
        }
        if(null == textView){
            Log.e("ListViewAdaptor", "null textView");
        }

        imageView.setImageResource(item.getResourceID());
        textView.setText(item.getName());
        return view;
    }
}
