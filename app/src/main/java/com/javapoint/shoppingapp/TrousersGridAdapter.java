package com.javapoint.shoppingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TrousersGridAdapter extends BaseAdapter {

    private Context context;
    private int trousers[];
    private String prices[];
    private LayoutInflater inflater;

    public TrousersGridAdapter(Context applicationContext, int[] trousers, String[] prices) {
        this.context = applicationContext;
        this.trousers = trousers;
        this.prices = prices;
        inflater = (LayoutInflater.from(applicationContext));/////////////// check application context if the app crashes
    }

    @Override
    public int getCount() {
        return trousers.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.grid_list_item, null);

        ImageView oneItemImage = convertView.findViewById(R.id.grid_item_image);
        TextView oneItemPrice = convertView.findViewById(R.id.grid_item_price);

        oneItemImage.setImageResource(trousers[position]);
        oneItemPrice.setText(prices[position]);

        return convertView;


    }
}
