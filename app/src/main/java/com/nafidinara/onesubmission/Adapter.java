package com.nafidinara.onesubmission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private final Context context;
    private ArrayList <Item> items;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Item item = (Item) getItem(position);
        viewHolder.bind(item);
        return view;
    }

     public Adapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

     public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    private class ViewHolder {
        private TextView tv_name;
        private TextView tv_release;
        private ImageView iv_imgphoto;

        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.txt_name);
            tv_release = view.findViewById(R.id.txt_release);
            iv_imgphoto = view.findViewById(R.id.img_photo);
        }

        public void bind(Item item) {
            tv_name.setText(item.getName());
            tv_release.setText(item.getRelease());
            iv_imgphoto.setImageResource(item.getImage());
        }
    }
}

