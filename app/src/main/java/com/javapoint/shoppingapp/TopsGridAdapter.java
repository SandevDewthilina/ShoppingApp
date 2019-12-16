package com.javapoint.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopsGridAdapter extends BaseAdapter {

    private Context context;
    private int tops[];
    private String prices[];
    private LayoutInflater inflater;

    public TopsGridAdapter(Context applicationContext, int[] tops, String[] prices) {
        this.context = applicationContext;
        this.tops = tops;
        this.prices = prices;
        inflater = (LayoutInflater.from(applicationContext));/////////////// check application context if the app crashes
    }


    @Override
    public int getCount() {
        return tops.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.grid_list_item, null);

        ImageView oneItemImage = convertView.findViewById(R.id.grid_item_image);
        TextView oneItemPrice = convertView.findViewById(R.id.grid_item_price);

        oneItemImage.setImageResource(tops[position]);
        oneItemPrice.setText(prices[position]);

        return convertView;

    }
}
