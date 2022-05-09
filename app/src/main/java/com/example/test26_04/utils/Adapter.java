package com.example.test26_04.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.test26_04.models.Item;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    final ArrayList<Item> itemList;

    public Adapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
