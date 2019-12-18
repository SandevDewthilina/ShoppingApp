package com.javapoint.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JeansGridAdapter extends BaseAdapter {

    private Context context;
    private int jeans[];
    private String prices[];
    private boolean liked[];
    private LayoutInflater inflater;


    public JeansGridAdapter(Context applicationContext, int[] dresses, String[] prices, boolean[] liked) {
        this.context = applicationContext;
        this.jeans = dresses;
        this.prices = prices;
        this.liked = liked;
        inflater = (LayoutInflater.from(applicationContext));/////////////// check application context if the app crashes
    }

    @Override
    public int getCount() {
        return jeans.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.grid_list_item, null);

        ImageView oneItemImage = convertView.findViewById(R.id.grid_item_image);
        TextView oneItemPrice = convertView.findViewById(R.id.grid_item_price);
        final ImageView likeBtn = convertView.findViewById(R.id.like_btn);
        final boolean[] status = {true};

        oneItemImage.setImageResource(jeans[position]);
        oneItemPrice.setText(prices[position]);

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (status[0]) {

                    liked[position] = true;

                    likeBtn.setImageResource(R.mipmap.like_icon);
                    status[0] = false;

                } else {

                    liked[position] = false;

                    likeBtn.setImageResource(R.mipmap.unlike_icon);
                    status[0] = true;

                }

            }
        });

        return convertView;


    }
}
