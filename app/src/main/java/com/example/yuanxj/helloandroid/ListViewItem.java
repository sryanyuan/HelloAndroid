package com.example.yuanxj.helloandroid;

/**
 * Created by yuanxj on 2015/5/5.
 */
public class ListViewItem {
    private String name;
    private int resourceID;

    public ListViewItem(String _name, int _rid){
        name = _name;
        resourceID = _rid;
    }

    public int getResourceID(){
        return resourceID;
    }

    public void setResourceID(int _id){
        resourceID = _id;
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }
}
