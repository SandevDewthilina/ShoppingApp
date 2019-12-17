package com.javapoint.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DressGridAdapter extends BaseAdapter {

    private Context context;
    private int dresses[];
    private String prices[];
    private LayoutInflater inflater;

    public DressGridAdapter(Context applicationContext, int[] dresses, String[] prices) {
        this.context = applicationContext;
        this.dresses = dresses;
        this.prices = prices;
        inflater = (LayoutInflater.from(applicationContext));       // check application context if the app crashes
    }


    @Override
    public int getCount() {
        return dresses.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"}) ///////////////// delete if crashed
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.grid_list_item, null);

        ImageView oneItemImage = convertView.findViewById(R.id.grid_item_image);
        TextView oneItemPrice = convertView.findViewById(R.id.grid_item_price);
        final ImageView likeBtn = convertView.findViewById(R.id.like_btn);
        final boolean[] status = {true};

        oneItemImage.setImageResource(dresses[position]);
        oneItemPrice.setText(prices[position]);

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (status[0]) {

                    likeBtn.setImageResource(R.mipmap.like_icon);
                    status[0] = false;
                } else {

                    likeBtn.setImageResource(R.mipmap.unlike_icon);
                    status[0] = true;
                }

            }
        });

        return convertView;


    }
}